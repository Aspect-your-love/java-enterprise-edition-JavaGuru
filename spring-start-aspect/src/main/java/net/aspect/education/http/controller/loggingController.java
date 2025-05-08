package net.aspect.education.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loggingController {
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }
}