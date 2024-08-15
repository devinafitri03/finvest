package apap.tk.finvest.controller;

import apap.tk.finvest.model.CompanyModel;
import apap.tk.finvest.model.PeranModel;
import apap.tk.finvest.model.UserModel;
import apap.tk.finvest.service.CompanyService;
import apap.tk.finvest.service.PeranService;
import apap.tk.finvest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private PeranService peranService;

    @Autowired
    private CompanyService companyService;

    @GetMapping(value="/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<PeranModel> listRole = peranService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        List<CompanyModel> listCompany = companyService.getListCompanyByStatus(List.of(1, 2));
        model.addAttribute("listCompany", listCompany);

        return "form-add-user";
    }

    @PostMapping(value="/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser(user);
        model.addAttribute("username", user.getUsername());

        return "add-user";
    }

    @GetMapping(value="")
    public String userCourse(Model model) {
        List<UserModel> listUser = userService.getListUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping(value="/{uuid}")
    public String detailUser(@PathVariable("uuid") Integer uuid, Model model) {
        UserModel user = userService.getUserByIdUser(uuid);
        model.addAttribute("user", user);
        return "view-user";
    }

    @GetMapping(value="/update/{uuid}")
    public String updateUserFormPage(
            @PathVariable("uuid") Integer uuid,
            Model model
    ) {
        Optional<UserModel> relatedUser = userService.getUserByUuid(uuid);
        List<PeranModel> listRole = peranService.findAll();
        List<CompanyModel> listCompany = companyService.getListCompanyByStatus(List.of(1, 2));
        model.addAttribute("listCompany", listCompany);
        model.addAttribute("listRole", listRole);
        UserModel user = relatedUser.get();
        model.addAttribute("user", user);
        
        return "form-update-user";
    }

    @PostMapping(value="/update/")
    public String updateUserSubmitPage(
            @ModelAttribute UserModel user,
            Model model
    ) {
        var userModel = new UserModel();
        userModel.setNama(user.getNama());
        userModel.setUsername(user.getUsername());
        userModel.setEmail(user.getEmail());
        userModel.setCompany(user.getCompany());
        userModel.setPassword(user.getPassword());
        userModel.setPeran(user.getPeran());

        UserModel updatedUser = userService.updateUser(user);
        model.addAttribute("updatedUser", updatedUser);
        model.addAttribute("uuid", user.getUuid());
        
        return "update-user";
    }

    @GetMapping(value="/delete/{uuid}")
    public String deleteUser(@PathVariable Integer uuid, Model model){
        UserModel user = userService.getUserByIdUser(uuid);
        model.addAttribute("user", user);
        userService.deleteUser(user);
        return "success-delete-user";

    }

}
