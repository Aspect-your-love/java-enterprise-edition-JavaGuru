package net.aspect.education.servletapplicationedu.service;

import net.aspect.education.servletapplicationedu.dao.UserDao;
import net.aspect.education.servletapplicationedu.dto.CreateUserDto;
import net.aspect.education.servletapplicationedu.entity.User;
import net.aspect.education.servletapplicationedu.mapper.CreateUserMapperDto;

public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserMapperDto createUserMapper = CreateUserMapperDto.getInstance();
    private final UserDao userDao = UserDao.getInstance();

    private UserService(){}

    public Integer create(CreateUserDto createUserDto){
        User user = createUserMapper.mapFrom(createUserDto);
        return userDao.save(user).getId();
    }

    public static UserService getInstance(){
        return INSTANCE;
    }

}
