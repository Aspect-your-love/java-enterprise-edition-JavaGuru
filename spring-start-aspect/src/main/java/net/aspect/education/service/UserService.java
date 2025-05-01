package net.aspect.education.service;

import lombok.ToString;
import net.aspect.education.database.mapper.UserMapper;
import net.aspect.education.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@ToString
@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }
}
