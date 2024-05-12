package by.VIWARR.TheFinalProject.controllers;

import by.VIWARR.TheFinalProject.services.CompanyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    public CompanyService companyService;

    @GetMapping("/loginPage")
    public String loginPage() {
        return "auth/loginPage";
    }

    @GetMapping("/registrationPage")
    public String registrationPage() {
        return "auth/registrationPage";
    }

    @PostMapping("/performRegistration")
    public String performRegistration(HttpServletRequest request) {
        String name = request.getParameter("companyName");
        String password = request.getParameter("password");
        String description = request.getParameter("description");

        if (companyService.findByName(name).isEmpty()) {
            companyService.save(name, password, description);
            return "redirect:/auth/loginPage";
        } else {
            return "auth/errorPage";
        }
    }
}
