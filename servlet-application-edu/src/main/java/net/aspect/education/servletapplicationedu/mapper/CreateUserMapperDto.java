package net.aspect.education.servletapplicationedu.mapper;

import net.aspect.education.servletapplicationedu.dto.CreateUserDto;
import net.aspect.education.servletapplicationedu.entity.User;
import net.aspect.education.servletapplicationedu.entity.enums.Gender;
import net.aspect.education.servletapplicationedu.entity.enums.Role;
import net.aspect.education.servletapplicationedu.utils.LocalDateFormatter;

import java.time.LocalDate;

public class CreateUserMapperDto implements Mapper<User, CreateUserDto> {
    private static final CreateUserMapperDto INSTANCE = new CreateUserMapperDto();

    private CreateUserMapperDto(){}

    @Override
    public User mapFrom(CreateUserDto dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setBirthday(LocalDateFormatter.format(dto.birthday()));
        user.setPassword(dto.password());
        user.setRole(Role.find(dto.role()).get());
        user.setGender(Gender.find(dto.gender()).get());

        return user;
    }

    public static CreateUserMapperDto getInstance(){
        return INSTANCE;
    }
}
