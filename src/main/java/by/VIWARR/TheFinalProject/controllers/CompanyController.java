package by.VIWARR.TheFinalProject.controllers;

import by.VIWARR.TheFinalProject.models.Company;
import by.VIWARR.TheFinalProject.security.CompanyDetails;
import by.VIWARR.TheFinalProject.services.AdminService;
import by.VIWARR.TheFinalProject.services.CompanyService;
import by.VIWARR.TheFinalProject.util.CompanyErrorResponse;
import by.VIWARR.TheFinalProject.util.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class CompanyController {

    private final CompanyService companyService;

    private final AdminService adminService;

    @Autowired
    public CompanyController (CompanyService companyService, AdminService adminService) {
        this.companyService = companyService;
        this.adminService = adminService;
    }

    @ResponseBody
    @GetMapping("/findAll")
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public Company findById(@PathVariable("id") int id) {
        return companyService.findById(id);
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

    @GetMapping("/admin")
    public String admin() {
        adminService.doAdminStuff();
        return "admin";
    }

    @ExceptionHandler
    private ResponseEntity<CompanyErrorResponse> handleException(CompanyNotFoundException e) {
        CompanyErrorResponse response = new CompanyErrorResponse(
                "Пользователь с id не найден",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}