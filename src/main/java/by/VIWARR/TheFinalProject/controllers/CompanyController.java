package by.VIWARR.TheFinalProject.controllers;

import by.VIWARR.TheFinalProject.security.CompanyDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CompanyController {

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
