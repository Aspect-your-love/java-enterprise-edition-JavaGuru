package net.aspect.education.database.mapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.aspect.education.database.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
public class UserMapper {

    private final UserDto userDto;

    public UserMapper(@Autowired UserDto userDto) {
        this.userDto = userDto;
    }
}
