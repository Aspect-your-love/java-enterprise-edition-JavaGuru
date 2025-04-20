package net.aspect.education.hibernate;

import lombok.extern.slf4j.Slf4j;
import net.aspect.education.hibernate.entity.*;
import net.aspect.education.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

@Slf4j
public class HibernateRunner {

    public static void main(String[] args) {
        Company company = Company.builder()
                .name("Yandex")
                .build();

        User user = User.builder()
                .username("mordor@developer.ru")
                .personalInfo(PersonalInfo.builder()
                        .firstname("Slavenia")
                        .lastname("Mordor")
                        .birthDate(new Birthday(LocalDate.of(2222, 10, 3)))
                        .build())
                .role(Role.ADMIN)
                .company(company)
                .build();

        try (SessionFactory factory = HibernateUtil.buildSessionFactory();
             Session session = factory.openSession()) {
            session.beginTransaction();

//            User user2 = session.get(User.class, 1);
//            System.out.println(user2);
            session.merge(user);
//            System.out.println(user2.getCompany().getName());

            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception: ", e);
            throw e;
        }
    }
}
