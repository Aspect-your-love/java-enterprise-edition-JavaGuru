package net.aspect.education.servletapplicationedu.validator;

import net.aspect.education.servletapplicationedu.dto.CreateUserDto;
import net.aspect.education.servletapplicationedu.entity.enums.Gender;
import net.aspect.education.servletapplicationedu.entity.enums.Role;
import net.aspect.education.servletapplicationedu.utils.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {
    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    private CreateUserValidator(){}

    public ValidatorResult isValid(CreateUserDto dto){
        ValidatorResult validatorResult = new ValidatorResult();
        if(!LocalDateFormatter.isValid(dto.birthday())) {
            validatorResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if (Gender.find(dto.gender()).isEmpty()){
            validatorResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        if (Role.find(dto.role()).isEmpty()){
            validatorResult.add(Error.of("invalid.role", "Role is invalid"));
        }
        return validatorResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
