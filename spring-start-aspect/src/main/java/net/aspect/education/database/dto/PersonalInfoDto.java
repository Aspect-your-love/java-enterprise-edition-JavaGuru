package net.aspect.education.database.dto;

import java.time.LocalDate;

public record PersonalInfoDto(String firstname, String lastname, LocalDate birthDay) {
}
