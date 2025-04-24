package net.aspect.education.hibernate.service;

import lombok.RequiredArgsConstructor;
import net.aspect.education.hibernate.dto.UserReadDto;
import net.aspect.education.hibernate.mapper.UserReadMapper;
import net.aspect.education.hibernate.repository.UserRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;

    public boolean delete(Long id){
        var maybeUser = userRepository.findById(id);
        maybeUser.ifPresentOrElse(user -> userRepository.delete(id),
                () -> {throw new RuntimeException("Юзер не найден");});

        return maybeUser.isPresent();
    }

    public Optional<UserReadDto> findUserById(Long id){
        return  userRepository.findById(id).map(userReadMapper::mapFrom);
    }

}
