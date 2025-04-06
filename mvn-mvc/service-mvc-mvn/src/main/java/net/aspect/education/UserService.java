package net.aspect.education;

import net.aspect.education.database.UserDao;

import java.util.Optional;

public class UserService {
    private final UserDao userDao = new UserDao();
    public Optional<UserDTO> getUser(Long id){

        return userDao.findById(id).map(it -> new UserDTO(it.getName()));
    }
}
