package net.aspect.education.database.mapper;

import net.aspect.education.database.dto.CompanyReadDto;
import net.aspect.education.database.dto.UserReadDto;
import net.aspect.education.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {
    private final CompanyReadMapper readMapper;

    @Autowired
    public UserReadMapper(CompanyReadMapper readMapper) {
        this.readMapper = readMapper;
    }

    @Override
    public UserReadDto map(User entity) {
        CompanyReadDto company = Optional
                .ofNullable(entity.getCompany())
                .map(readMapper::map)
                .orElse(null);

        return new UserReadDto(
                entity.getId(),
                entity.getUsername(),
                entity.getBirthDay(),
                entity.getFirstname(),
                entity.getLastname(),
                entity.getRole(),
                entity.getImage(),
                company);
    }
}
