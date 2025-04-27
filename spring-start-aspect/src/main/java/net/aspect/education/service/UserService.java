package net.aspect.education.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.aspect.education.database.mapper.UserMapper;
import net.aspect.education.database.repository.UserRepository;

@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
}
