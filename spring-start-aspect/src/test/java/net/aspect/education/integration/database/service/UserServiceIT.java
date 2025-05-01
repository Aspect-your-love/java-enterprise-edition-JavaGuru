package net.aspect.education.integration.database.service;

import net.aspect.education.service.UserService;
import net.aspect.education.annotation.IT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@IT
//@SpringBootTest
public class UserServiceIT {
    private final UserService userService;

    public UserServiceIT(@Autowired UserService userService){
        this.userService = userService;
    }

    @Test
    public void test1(){

    }
}
