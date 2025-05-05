package net.aspect.education.fast_rest_api;


import lombok.RequiredArgsConstructor;
import net.aspect.education.fast_rest_api.database.dto.UserReadDto;
import net.aspect.education.fast_rest_api.database.entity.User;
import net.aspect.education.fast_rest_api.database.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public UserReadDto findById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        return new UserReadDto(user.getId(), user.getUsername(), user.getFirstname(), user.getLastname(), user.getCity(), user.getDescription());
    }
}
