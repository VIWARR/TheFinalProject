package by.VIWARR.TheFinalProject.controllers;

import by.VIWARR.TheFinalProject.security.UserDetailsImpl;
import by.VIWARR.TheFinalProject.services.UserDetailServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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

    @GetMapping("/w1")
    public String getUser(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        model.addAttribute("user", userDetails);

        return "hello";
    }

    @GetMapping("/w2")
    public String getUser(Model model, HttpServletRequest request) {
        Authentication authentication = (Authentication) request.getUserPrincipal();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("user", userDetails);

        return "hello";
    }

    @GetMapping("/w3")
    public String getUser(Model model,
                          @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("user", userDetails);

        return "hello";
    }

    @GetMapping("/free")
    public String free() {
        return "free";
    }
}