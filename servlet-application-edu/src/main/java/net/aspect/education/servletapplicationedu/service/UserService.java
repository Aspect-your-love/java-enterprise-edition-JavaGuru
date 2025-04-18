package net.aspect.education.servletapplicationedu.service;

import net.aspect.education.servletapplicationedu.dao.UserDao;
import net.aspect.education.servletapplicationedu.dto.CreateUserDto;
import net.aspect.education.servletapplicationedu.dto.UserDto;
import net.aspect.education.servletapplicationedu.entity.User;
import net.aspect.education.servletapplicationedu.exception.ValidationException;
import net.aspect.education.servletapplicationedu.mapper.CreateUserMapperDto;
import net.aspect.education.servletapplicationedu.mapper.UserMapper;
import net.aspect.education.servletapplicationedu.validator.CreateUserValidator;
import net.aspect.education.servletapplicationedu.validator.ValidatorResult;

import java.util.Optional;

public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserMapperDto createUserMapper = CreateUserMapperDto.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
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

    public Optional<UserDto> login(String email, String pwd) {
        return userDao.getByEmailAndPassword(email, pwd).map(userMapper::mapFrom);
    }
}
