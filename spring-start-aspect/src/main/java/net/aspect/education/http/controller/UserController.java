package net.aspect.education.http.controller;

import lombok.extern.slf4j.Slf4j;
import net.aspect.education.database.dto.PageResponse;
import net.aspect.education.database.dto.UserCreateEditDto;
import net.aspect.education.database.dto.UserFilter;
import net.aspect.education.database.dto.UserReadDto;
import net.aspect.education.database.entity.Role;
import net.aspect.education.service.CompanyService;
import net.aspect.education.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

/**
 *
 *
 * @author Aspect
 * @date 2025/05/09 00:50
 */
@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;
    private final CompanyService companyService;

    @Autowired
    public UserController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }

    @GetMapping
    public String findAll(Model model, UserFilter filter, Pageable pageable) {
        Page<UserReadDto> page = userService.findAll(filter, pageable);
        model.addAttribute("users", PageResponse.of(page));
        model.addAttribute("filter", filter);
        return "user/users";
    }

    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute("user") UserCreateEditDto user) {

        if (user == null) {
            user = new UserCreateEditDto("",
                    LocalDate.now(),
                    "",
                    "",
                    Role.USER,
                    1,
                    null);
        }

        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("companies", companyService.findAll());
        return "user/registration";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'CEO')")
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id,
                           Model model,
                           @AuthenticationPrincipal UserDetails userDetails) {
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
    public String create(@ModelAttribute @Validated UserCreateEditDto user,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/users/registration";
        }

        UserReadDto dto = userService.create(user);
        return "redirect:/users/" + dto.getId();
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute @Validated UserCreateEditDto userDto) {
        userService.update(id, userDto).map(it -> "redirect:/user/{id}")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return "redirect:/users/{id}";
    }

    @PostMapping("/{id}/delete")
    public String delete() {
        return "redirect:/users";
    }
}
