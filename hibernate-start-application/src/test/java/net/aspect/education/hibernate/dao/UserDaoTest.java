package net.aspect.education.hibernate.dao;

import lombok.Cleanup;
import net.aspect.education.hibernate.entity.PersonalInfo;
import net.aspect.education.hibernate.entity.Profile;
import net.aspect.education.hibernate.entity.User;
import net.aspect.education.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


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

    @Test
    @Disabled
    public void findAllByFirstName() {
        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        User user1 = User.builder()
                .username("buba@kaluga.ru")
                .personalInfo(PersonalInfo.builder().firstname("Ivon").lastname("Test").build())
                .build();

        User user2 = User.builder()
                .username("buba-2@kaluga.ru")
                .personalInfo(PersonalInfo.builder().firstname("Ivon").lastname("Leviska").build())
                .build();

        User user3 = User.builder()
                .username("buba-3@kaluga.ru")
                .personalInfo(PersonalInfo.builder().firstname("Takhikardia").lastname("Zolotuha").build())
                .build();

        session.beginTransaction();

        session.persist(user1);
        session.persist(user2);
        session.persist(user3);

        List<User> ivon = userDao.findByFirstName(session, "Ivon");

        List<String> list = ivon.stream().map(user -> user.getUsername()).toList();

        session.getTransaction().commit();

        assertThat(list).containsAnyOf("buba@kaluga.ru", "buba-2@kaluga.ru");

    }
}