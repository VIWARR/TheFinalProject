package by.VIWARR.TheFinalProject.controllers;

import by.VIWARR.TheFinalProject.security.CompanyDetails;
import by.VIWARR.TheFinalProject.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CompanyController {

    @Autowired
    public CompanyService companyService;


    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("companies", companyService.findAll());

        return "findAll";
    }

    @GetMapping("/free")
    public String free() {
        return "free";
    }

    @GetMapping("/getCompany")
    public String getCompany(Model model,
                             @AuthenticationPrincipal UserDetails userDetails) {
        CompanyDetails companyDetails = (CompanyDetails) userDetails;
        model.addAttribute("company", companyDetails.getCompany());

        return "getCompany";
    }
}