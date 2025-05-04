package net.aspect.education.database.repository;

import net.aspect.education.database.dto.UserFilter;
import net.aspect.education.database.entity.User;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter userFilter);
}
