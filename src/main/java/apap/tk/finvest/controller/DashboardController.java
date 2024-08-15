package apap.tk.finvest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import apap.tk.finvest.model.CompanyModel;
import apap.tk.finvest.service.CompanyService;
import apap.tk.finvest.service.KategoriService;
import apap.tk.finvest.service.ProjectService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private KategoriService kategoriService;

    @RequestMapping("")
    public String dashboard(Model model) {
        List<CompanyModel> listCompany = companyService.getListCompany();

        model.addAttribute("listCompany", listCompany);

        return "dashboard";
    }
}
