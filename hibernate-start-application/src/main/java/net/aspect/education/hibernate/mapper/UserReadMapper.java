package net.aspect.education.hibernate.mapper;

import lombok.RequiredArgsConstructor;
import net.aspect.education.hibernate.dto.UserReadDto;
import net.aspect.education.hibernate.entity.User;

@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {
    private final CompanyReadMapper mapper;

    @Override
    public UserReadDto mapFrom(User user) {
        new UserReadDto(
                    user.getId()
                , user.getPersonalInfo()
                , user.getUsername()
                , user.getRole()
                , mapper.mapFrom(user.getCompany()));
        return null;
    }
}
