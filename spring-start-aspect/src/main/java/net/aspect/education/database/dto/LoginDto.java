package net.aspect.education.database.dto;

import lombok.Value;
import net.aspect.education.database.entity.Role;

import java.time.LocalDate;

@Value
public class LoginDto {
    String username;
    String password;
}

