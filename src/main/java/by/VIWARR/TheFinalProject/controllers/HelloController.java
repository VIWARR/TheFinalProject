package by.VIWARR.TheFinalProject.controllers;

import by.VIWARR.TheFinalProject.security.UserDetailsImpl;
import by.VIWARR.TheFinalProject.services.UserDetailServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping("/")
    public String info(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        model.addAttribute("user", userDetails.getUser());

        return "hello";
    }
}
