package net.aspect.education.integration.database.service;

import lombok.RequiredArgsConstructor;
import net.aspect.education.annotation.IT;
import net.aspect.education.database.dto.UserReadDto;
import net.aspect.education.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
@Transactional
class UserServiceTest {
    private final static Long USER_ID = 1L;
    private final UserService userService;

    @Test
    void findAll(){
        List<UserReadDto> result = userService.findAll();

        assertAll(
                () -> assertThat(result).hasSize(10)
        );
    }

    @Test
    void findById(){
        Optional<UserReadDto> byId = userService.findById(USER_ID);

        assertThat(byId).isPresent();
        byId.ifPresent(userReadDto -> assertEquals("aspect@dev.ru", byId.get().getUsername()));
    }


}