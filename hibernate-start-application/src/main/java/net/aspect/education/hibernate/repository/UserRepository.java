package net.aspect.education.hibernate.repository;

import jakarta.persistence.EntityManager;
import net.aspect.education.hibernate.entity.User;

public class UserRepository extends BaseRepository<Long, User>{
    public UserRepository(EntityManager entityManager) {
        super(User.class, entityManager);
    }
}
