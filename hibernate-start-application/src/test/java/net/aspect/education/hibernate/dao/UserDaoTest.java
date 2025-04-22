package net.aspect.education.hibernate.dao;

import lombok.Cleanup;
import net.aspect.education.hibernate.entity.User;
import net.aspect.education.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private final UserDao userDao = UserDao.getInstance();

    @Test
    void findAll() {
        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        session.beginTransaction();
        User userTest = new User();
        userTest.setUsername("JSON");
        session.persist(userTest);

        List<User> all = userDao.findAll(session);

        System.out.println(all);

        session.getTransaction().commit();
    }
}