package com.example.demo15.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/home")
    public String getTestPage() {
        return "home";
    }
}
