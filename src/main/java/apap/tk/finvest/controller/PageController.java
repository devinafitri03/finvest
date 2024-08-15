package apap.tk.finvest.controller;

import java.security.Principal;
import java.util.jar.Attributes;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import apap.tk.finvest.model.UserModel;
import apap.tk.finvest.security.xml.ServiceResponse;
import apap.tk.finvest.service.PeranService;
import apap.tk.finvest.service.UserService;
import apap.tk.finvest.setting.Setting;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {
    @Autowired
    private UserService userService;
    private PeranService peranService;

    private WebClient webClient = WebClient.builder().build();

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
}
