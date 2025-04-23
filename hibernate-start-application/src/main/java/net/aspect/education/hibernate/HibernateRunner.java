package net.aspect.education.hibernate;

import jakarta.persistence.LockModeType;
import lombok.extern.slf4j.Slf4j;
import net.aspect.education.hibernate.entity.*;
import net.aspect.education.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.graph.GraphSemantic;
import org.hibernate.graph.RootGraph;
import org.hibernate.graph.SubGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Slf4j
public class HibernateRunner {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session.find(User.class, 1L);
            var user1 = session.find(User.class, 1L);
            user1.getCompany();
            session.getTransaction().commit();
        } catch (Exception e) {
            sessionFactory.close();
        }

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            var user2 = session.find(User.class, 1L);
            user2.getCompany();
            session.getTransaction().commit();
        } catch (Exception e) {
            sessionFactory.close();
        }
    }
}
