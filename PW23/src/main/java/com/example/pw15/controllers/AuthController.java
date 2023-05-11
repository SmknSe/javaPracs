package com.example.pw15.controllers;

import com.example.pw15.entities.User;
import com.example.pw15.services.UserAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final UserAppService userAppService;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/reg")
    public String getRegistrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/reg")
    public String signUpUser(@ModelAttribute("user") User user) {
        return userAppService.signUpUser(user);
    }
}
