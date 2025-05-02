package net.aspect.education.http.controller;

import net.aspect.education.database.dto.UserCreateEditDto;
import net.aspect.education.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        return "user/user";
    }

    @PostMapping
    public String create(@ModelAttribute UserCreateEditDto user){

        return "redirect:/users/" + 25;
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute UserCreateEditDto userDto){


        return "redirect:/users/{id}";
    }

    @PostMapping("/{id}/delete")
    public String delete(){
        return "redirect:/users";
    }

}
