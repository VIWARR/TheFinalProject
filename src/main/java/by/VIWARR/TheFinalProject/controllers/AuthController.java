package by.VIWARR.TheFinalProject.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

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
        String password = request.getParameter("pasword");
        String description = request.getParameter("description");


    }
}
