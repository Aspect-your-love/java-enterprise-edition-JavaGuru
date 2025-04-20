package net.aspect.education.hibernate;

import lombok.extern.slf4j.Slf4j;
import net.aspect.education.hibernate.entity.Birthday;
import net.aspect.education.hibernate.entity.PersonalInfo;
import net.aspect.education.hibernate.entity.Role;
import net.aspect.education.hibernate.entity.User;
import net.aspect.education.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

@Slf4j
public class HibernateRunner {

    public static void main(String[] args) {
        User user = User.builder()
                .username("kulagin@developer.ru")
                .personalInfo(PersonalInfo.builder()
                .firstname("Viktor")
                .lastname("Kulagin")
                .birthDate(new Birthday(LocalDate.of(2001, 1, 1)))
                .build())
                .role(Role.ADMIN)
                .build();
        log.info("User object in transient state: {}", user);

        try (SessionFactory factory = HibernateUtil.buildSessionFactory();
             Session session = factory.openSession()) {
            session.beginTransaction();

            session.merge(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception: ", e);
            throw e;
        }
    }
}
