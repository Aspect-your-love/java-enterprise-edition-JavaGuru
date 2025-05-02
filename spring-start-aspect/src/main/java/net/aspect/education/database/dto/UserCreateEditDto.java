package net.aspect.education.database.dto;

import lombok.Data;
import lombok.Value;
import net.aspect.education.database.entity.Role;

import java.time.LocalDate;

@Value
public class UserCreateEditDto {
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
