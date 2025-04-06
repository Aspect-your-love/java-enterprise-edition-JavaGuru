package net.aspect.education.database;

import java.util.Optional;

public class UserDao {

    public Optional<User> findById(Long id){
        User user = new User();
        user.setName(String.valueOf("Андрей"));
        return Optional.of(user);
    }
}
