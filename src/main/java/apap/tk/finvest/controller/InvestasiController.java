package apap.tk.finvest.controller;

import apap.tk.finvest.model.CompanyModel;
import apap.tk.finvest.model.InvestasiModel;
import apap.tk.finvest.model.InvestorModel;
import apap.tk.finvest.model.UserModel;
import apap.tk.finvest.service.CompanyService;
import apap.tk.finvest.service.InvestasiService;
import apap.tk.finvest.service.InvestorService;
import apap.tk.finvest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/investasi")
public class InvestasiController {
    @Autowired
    InvestorService investorService;
    @Autowired
    CompanyService companyService;
    @Autowired
    InvestasiService investasiService;
    @Autowired
    UserService userService;


    @GetMapping("")
    private String viewInvestasi(@AuthenticationPrincipal UserDetails activeUser, Model model){
        UserModel user = userService.getUserByUsername(activeUser.getUsername());
        InvestorModel investor = user.getInvestor();
        //        return to landing if investor is none
        if(investor == null){
            return "redirect:/investasi/landing";
        }

        List<InvestasiModel> listInvestasi = investasiService.getInvestasiByInvestor(investor);
        model.addAttribute("investor", investor);
        model.addAttribute("listInvestasi", listInvestasi);
        return "view-investasi";
    }

    @GetMapping("/add")
    private String addInvestasi(@AuthenticationPrincipal UserDetails activeUser, Model model){
        UserModel user = userService.getUserByUsername(activeUser.getUsername());
        InvestorModel investor = user.getInvestor();
        List<CompanyModel> listCompany = companyService.getListCompany();
        model.addAttribute("listCompany", listCompany);
        model.addAttribute("investor", investor);
        InvestasiModel investasi = new InvestasiModel();
        model.addAttribute("investasi", investasi);
        return "form-add-investasi";
    }

    @PostMapping("/add")
    private String addInvestasiSubmit(@ModelAttribute("investasi") InvestasiModel investasi, Model model){
        List<InvestasiModel> investasiHistory = investasiService.getInvestasiByInvestor(investasi.getIdInvestor());
        for(InvestasiModel inv : investasiHistory){
            if(inv.getIdPerusahaan() == investasi.getIdPerusahaan() &&
                    inv.getTahunFiskal().equals(investasi.getTahunFiskal()) &&
                    inv.getPeriodeFiskal().equals(investasi.getPeriodeFiskal())){
                return "add-investasi-failure";
            }
        }

        investasiService.addInvestasi(investasi);
        model.addAttribute("investasi", investasi);

//        update saldo logic
        Integer jumlahInvestasi = investasi.getJumlahInvestasi();
        Integer saldoLama = investasi.getIdPerusahaan().getSaldo_perusahaan();
        CompanyModel oldCompany = investasi.getIdPerusahaan();
        oldCompany.setSaldo_perusahaan(saldoLama+jumlahInvestasi);
        companyService.updateCompany(oldCompany);

//
        return "add-investasi-success";
    }

    @GetMapping("/landing")
    private String addInvestor(@AuthenticationPrincipal UserDetails activeUser, Model model){
        UserModel user = userService.getUserByUsername(activeUser.getUsername());
        InvestorModel userHasInvestor = user.getInvestor();
        System.out.println(userHasInvestor);
        if(userHasInvestor == null){
            return "landing-investasi";
        }
        else{
            return "redirect:/investasi";
        }

    }

    @PostMapping("/landing")
    private String addInvestorSubmit(@AuthenticationPrincipal UserDetails activeUser, @ModelAttribute("investor") InvestorModel investor, Model model){
        UserModel user = userService.getUserByUsername(activeUser.getUsername());
        InvestorModel isInvestorAlreadyExists = investorService.getInvestorByInvestorName(investor.getNamaInvestor());
        if(isInvestorAlreadyExists == null){
            investorService.addInvestor(investor);
        }
        else{
            investor = isInvestorAlreadyExists;
        }

        user.setInvestor(investor);
        userService.updateUser(user);
        model.addAttribute("investor", investor);

        return "landing-investasi-success";

    }
}
