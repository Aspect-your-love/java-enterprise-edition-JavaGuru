package net.aspect.education.database.mapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.aspect.education.database.dto.UserDto;

@RequiredArgsConstructor
@ToString
public class UserMapper {
    private final UserDto userDto;
}
