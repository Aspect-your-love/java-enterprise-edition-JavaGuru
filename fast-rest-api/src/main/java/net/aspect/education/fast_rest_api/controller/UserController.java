package net.aspect.education.fast_rest_api.controller;

import lombok.RequiredArgsConstructor;
import net.aspect.education.fast_rest_api.UserService;
import net.aspect.education.fast_rest_api.database.dto.UserReadDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserReadDto getUserById(@PathVariable("id") long id) {
        return userService.findById(id);
    }
}
