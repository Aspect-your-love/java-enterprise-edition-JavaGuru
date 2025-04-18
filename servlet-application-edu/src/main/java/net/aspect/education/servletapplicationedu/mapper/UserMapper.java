package net.aspect.education.servletapplicationedu.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.aspect.education.servletapplicationedu.dto.UserDto;
import net.aspect.education.servletapplicationedu.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<UserDto, User>{
    private static final UserMapper INSTANCE = new UserMapper();


    @Override
    public UserDto mapFrom(User user) {

        return UserDto
                .builder()
                .id(Long.valueOf(user.getId()))
                .name(user.getName())
                .birthday(user.getBirthday())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .gender(user.getGender())
                .build();
    }

    public static UserMapper getInstance(){
        return INSTANCE;
    }
}
