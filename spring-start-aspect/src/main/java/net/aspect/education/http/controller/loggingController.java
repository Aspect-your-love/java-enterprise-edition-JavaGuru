package net.aspect.education.http.controller;

import net.aspect.education.database.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loggingController {
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }
    @PostMapping("/login")
    public void postLogin(Model model, @ModelAttribute("login") LoginDto loginDto){

    }
}
