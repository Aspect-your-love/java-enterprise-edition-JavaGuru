package net.aspect.education.http.controller;

import net.aspect.education.database.dto.UserCreateEditDto;
import net.aspect.education.database.dto.UserReadDto;
import net.aspect.education.database.entity.Role;
import net.aspect.education.service.CompanyService;
import net.aspect.education.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CompanyService companyService;

    @Autowired
    public UserController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute("user") UserCreateEditDto user) {

        if (user == null) {
            user = new UserCreateEditDto("", LocalDate.now(), "", "", Role.USER, 1);
        }

        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("companies", companyService.findAll());
        return "user/registration";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        return userService.findById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    model.addAttribute("roles", Role.values());
                    model.addAttribute("companies", companyService.findAll());
                    return "user/user";
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public String create(@ModelAttribute UserCreateEditDto user,
                         RedirectAttributes redirectAttributes){
        if (true){
            /*redirectAttributes.addAttribute("username", user.getUsername());
            redirectAttributes.addAttribute("firstname", user.getFirstname());*/
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/users/registration";
        }

        UserReadDto dto = userService.create(user);
        return "redirect:/users/" + dto.getId();
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
