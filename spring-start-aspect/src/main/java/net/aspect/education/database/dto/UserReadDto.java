package net.aspect.education.database.dto;

import lombok.Value;
import net.aspect.education.database.entity.Role;

import java.time.LocalDate;

@Value
public class UserReadDto {
    Long id;
    String username;

    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    String image;
    CompanyReadDto company;
}
