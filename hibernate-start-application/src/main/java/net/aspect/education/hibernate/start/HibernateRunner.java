package net.aspect.education.hibernate.start;

import net.aspect.education.hibernate.start.converter.BirthdayConverter;
import net.aspect.education.hibernate.start.entity.Birthday;
import net.aspect.education.hibernate.start.entity.Role;
import net.aspect.education.hibernate.start.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.addAnnotatedClass(User.class);
        configuration.addAttributeConverter(BirthdayConverter.class, true);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            Session session = factory.openSession();

            User user = User.builder()
                    .username("kulagin1@developer.ru")
                    .firstName("Viktor")
                    .lastname("Leroy")
                    .birthDate(new Birthday(LocalDate.of(2001, 1, 1)))
                    .role(Role.ADMIN)
                    .build();

            session.beginTransaction();
//            session.save(user);
            session.saveOrUpdate(user);

            session.getTransaction().commit();
        }
    }
}
