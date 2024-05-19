package by.VIWARR.TheFinalProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

    @GetMapping("/ajaxController")
    public String ajaxController() {
        return "ajaxHTML";
    }

    @GetMapping("/ajaxGet")
    @ResponseBody
    public String handleAjaxGet(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/ajaxPost")
    @ResponseBody
    public String handleAjaxPost(@RequestParam String name) {
        return "Hello, " + name + "!";
    }


    @GetMapping("/converter")
    public String formConverter() {
        return "converter";
    }

    @GetMapping("/getAmount")
    @ResponseBody
    public String getAmount(@RequestParam("amount") double amount) {
        double convertedAmount = amount / 3.2;
        return String.format("%.2f", convertedAmount);
    }
}