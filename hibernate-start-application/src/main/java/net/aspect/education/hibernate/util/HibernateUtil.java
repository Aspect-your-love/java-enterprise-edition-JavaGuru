package net.aspect.education.hibernate.util;

import net.aspect.education.hibernate.converter.BirthdayConverter;
import net.aspect.education.hibernate.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration().configure();

        configuration.addAttributeConverter(new BirthdayConverter());
        return configuration.buildSessionFactory();
    }
}
