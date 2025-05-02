package net.aspect.education.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.aspect.education.database.dto.UserCreateEditDto;
import net.aspect.education.database.dto.UserReadDto;
import net.aspect.education.database.mapper.UserCreateEdditMapper;
import net.aspect.education.database.mapper.UserReadMapper;
import net.aspect.education.database.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@ToString
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)     //Повышаем производительность
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEdditMapper userCreateEdditMapper;

    public List<UserReadDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userReadMapper::map)
                .toList();
    }

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id).map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(userCreateEdditMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateEditDto userDto) {
        return userRepository
                .findById(id)
                .map(e -> userCreateEdditMapper.map(userDto, e))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepository.findById(id).map(e -> {
                    userRepository.delete(e);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}

