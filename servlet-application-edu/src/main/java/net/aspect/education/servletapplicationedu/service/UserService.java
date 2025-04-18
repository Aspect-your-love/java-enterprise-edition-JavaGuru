package net.aspect.education.servletapplicationedu.service;

import net.aspect.education.servletapplicationedu.dao.UserDao;
import net.aspect.education.servletapplicationedu.dto.CreateUserDto;
import net.aspect.education.servletapplicationedu.entity.User;
import net.aspect.education.servletapplicationedu.exception.ValidationException;
import net.aspect.education.servletapplicationedu.mapper.CreateUserMapperDto;
import net.aspect.education.servletapplicationedu.validator.CreateUserValidator;
import net.aspect.education.servletapplicationedu.validator.ValidatorResult;

public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserMapperDto createUserMapper = CreateUserMapperDto.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserValidator validator = CreateUserValidator.getInstance();

    private UserService(){}

    public Integer create(CreateUserDto createUserDto){
        ValidatorResult validResult = validator.isValid(createUserDto);
        if (!validResult.isValid()) {
            throw new ValidationException(validResult.getErrors());
        }
        User user = createUserMapper.mapFrom(createUserDto);
        return userDao.save(user).getId();
    }

    public static UserService getInstance(){
        return INSTANCE;
    }

}
