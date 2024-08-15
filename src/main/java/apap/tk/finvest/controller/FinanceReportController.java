package apap.tk.finvest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import apap.tk.finvest.model.FinanceReportModel;
import apap.tk.finvest.service.FinanceReportService;

@Controller
public class FinanceReportController {
    @Autowired
    private FinanceReportService financeReportService;

    @Qualifier("financeReportServiceImpl")

    @GetMapping("/redirectFinance")
    public ModelAndView redirectFinance(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_Admin"))) {
            System.out.println("anjay atmin");
            return new ModelAndView("redirect:/finance");

        } else {
            System.out.println("kasta rendah");
            return new ModelAndView("redirect:/finance");
        }
    }

    @GetMapping("/finance/add")
    public String addFinanceFormPage(Model model) {
        model.addAttribute("finance", new FinanceReportModel());
        return "FormFinanceReportAddItem";
    }

    @PostMapping("/finance/add")
    public String addCourseSubmitPage(@ModelAttribute FinanceReportModel finance, Model model) {
        if (finance.getJumlah_investor() == null) {
            finance.setJumlah_investor(1); // asumsinya dalam suatu project terdapat setidaknya satu investor
        }

        if (finance.getNet_profit() == null) {
            finance.setNet_profit(1);
        } else {
            finance.setNet_profit(financeReportService.getNetProfit(finance));
        }

        financeReportService.addItem(finance);
        model.addAttribute("proyek", finance.getProyek());
        return "FinanceReportAddItem";
    }

    @DeleteMapping("/finance/delete/{uuid}")
    public String deleteItem(@PathVariable Integer uuid, Model model) {
        FinanceReportModel targetProyek = financeReportService.getProyekById(uuid);
        financeReportService.deleteItem(targetProyek);
        return "FinanceReportDeleteItem";
    }

    @GetMapping("/finance")
    public String listProyek(Model model) {
        // Mendapatkan semua CourseModel
        List<FinanceReportModel> listProyek = financeReportService.getListFinanceReport();

        // Add variable semua courseModel ke "ListCourse" untuk dirender pada thymeleaf
        model.addAttribute("listProyek", listProyek);
        return "ViewAllFinanceReport";
    }

    @GetMapping("/finance/view/{uuid}")
    public String viewProyekDetail(@PathVariable Integer uuid, Model model) {
        FinanceReportModel financeReport = financeReportService.getProyekById(uuid);

        // Add variable semua courseModel ke "ListCourse" untuk dirender pada thymeleaf
        model.addAttribute("proyek", financeReport);
        return "ViewFinanceReport";
    }

    @GetMapping("/finance/update/{uuid}")
    public String updateReportFormPage(@PathVariable Integer uuid, Model model) {
        FinanceReportModel proyek = financeReportService.getProyekById(uuid);
        model.addAttribute("proyek", proyek);

        return "FormFinanceReportUpdateItem";
    }

    @PostMapping("/finance/update")
    public String updateReportSubmitPage(@ModelAttribute FinanceReportModel finance) {
        Integer proyek = finance.getProyek();

        financeReportService.updateItem(finance);
        return "redirect:/finance/view/" + proyek;
    }
}
