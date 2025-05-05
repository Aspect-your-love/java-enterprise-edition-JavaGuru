package net.aspect.education.fast_rest_api.database.repository;

import net.aspect.education.fast_rest_api.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserById(Long id);
}
