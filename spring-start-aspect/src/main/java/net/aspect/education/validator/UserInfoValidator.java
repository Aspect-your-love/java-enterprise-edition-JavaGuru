package net.aspect.education.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import net.aspect.education.database.dto.UserCreateEditDto;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserInfoValidator implements ConstraintValidator<UserInfo, UserCreateEditDto> {
    @Override
    public boolean isValid(UserCreateEditDto o, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(o.getFirstname()) || StringUtils.hasText(o.getLastname());
    }
}
