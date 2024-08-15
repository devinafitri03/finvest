package apap.tk.finvest.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import java.util.List;
import apap.tk.finvest.model.CompanyModel;
import apap.tk.finvest.model.KategoriModel;
import apap.tk.finvest.model.SubkategoriModel;
import apap.tk.finvest.service.CompanyService;
import apap.tk.finvest.service.KategoriService;
import apap.tk.finvest.service.SubkategoriService;


@Controller 
public class CompanyController {
    @Qualifier("companyServiceImpl")
    @Autowired
    private CompanyService companyService;

    @Autowired
    private KategoriService kategoriService;

    @Autowired
    private SubkategoriService subkategoriService;

    @GetMapping("/company/add")
    public String addCompanyFormPage(Model model) {
        CompanyModel company = new CompanyModel();
        List<KategoriModel> listKategori = kategoriService.getListKategori();
        List<SubkategoriModel> listSubkategori = subkategoriService.getListSubkategori();
        model.addAttribute("company", company);
        model.addAttribute("listKategori", listKategori);
        model.addAttribute("listSubkategori", listSubkategori);

        return "form-add-company";
    }

    @PostMapping("/company/add")
    public String addCompanySubmitPage(@ModelAttribute CompanyModel company, Model model) {
        companyService.addCompany(company);
        model.addAttribute("uuid", company.getUuid());

        return "add-company";
    }

    @GetMapping("/company")
    public String listCompany(Model model) {
        List<CompanyModel> listCompany = companyService.getListCompany();
        model.addAttribute("listCompany", listCompany);
        return "viewall-company";
    }

    
    @GetMapping("company/update/{uuid}")
    public String updateCourseFormPage(
            @PathVariable("uuid") Integer uuid,
            Model model
    ) {
        CompanyModel company = companyService.getCompanyByUuid(uuid);
        List<KategoriModel> listKategori = kategoriService.getListKategori();
        List<SubkategoriModel> listSubkategori = subkategoriService.getListSubkategori();
        model.addAttribute("company", company);
        model.addAttribute("listKategori", listKategori);
        model.addAttribute("listSubkategori", listSubkategori);

        return "form-update-company";
    }

    @PostMapping("company/update")
    public String updateCompanySubmitPage(
            @ModelAttribute CompanyModel company,
            Model model
    ) {
        CompanyModel updatedCompany = companyService.updateCompany(company);
        
        model.addAttribute("uuid", updatedCompany.getUuid());
        
        return "update-company";
    }

    @GetMapping("company/view/{uuid}")
    public String getDetailCompany(@PathVariable Integer uuid, Model model){
        CompanyModel company = companyService.getCompanyByUuid(uuid);
        model.addAttribute("company", company);

        return "view-company";
    }

}
