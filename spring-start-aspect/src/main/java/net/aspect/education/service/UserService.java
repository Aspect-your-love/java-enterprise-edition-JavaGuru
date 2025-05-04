package net.aspect.education.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.aspect.education.database.dto.QPredicates;
import net.aspect.education.database.dto.UserCreateEditDto;
import net.aspect.education.database.dto.UserFilter;
import net.aspect.education.database.dto.UserReadDto;
import net.aspect.education.database.mapper.UserCreateEdditMapper;
import net.aspect.education.database.mapper.UserReadMapper;
import net.aspect.education.database.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static net.aspect.education.database.entity.QUser.user;

@ToString
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)     //Повышаем производительность. Только для чтения.
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEdditMapper userCreateEdditMapper;

    public Page<UserReadDto> findAll(UserFilter filter, Pageable pageable){
        var predicate = QPredicates.builder()
                .add(filter.firstname(), user.firstname::containsIgnoreCase)
                .add(filter.lastname(), user.lastname::containsIgnoreCase)
                .add(filter.birthDay(), user.birthDay::before)
                .build();
        return userRepository.findAll(predicate, pageable).map(userReadMapper::map);
    }

    public List<UserReadDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userReadMapper::map)
                .toList();
    }

    public List<UserReadDto> findAll(UserFilter userFilter) {
        return userRepository
                .findAllByFilter(userFilter)
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

