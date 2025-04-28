package net.aspect.education.integer.service;

import lombok.RequiredArgsConstructor;
import net.aspect.education.UserService;
import net.aspect.education.annotation.IT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@IT
public class UserServiceIT {
    private final UserService userService;


    public UserServiceIT(@Autowired UserService userService){
        this.userService = userService;
    }

    @Test
    public void test1(){

    }
}
