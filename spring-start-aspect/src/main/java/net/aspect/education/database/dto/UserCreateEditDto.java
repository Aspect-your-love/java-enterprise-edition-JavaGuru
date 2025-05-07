package net.aspect.education.database.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import net.aspect.education.database.entity.Role;
import net.aspect.education.validator.UserInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo
public class UserCreateEditDto {
    @Email
    String username;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate birthDate;
    @Size(min = 3, max = 30)
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
    MultipartFile image;
}
