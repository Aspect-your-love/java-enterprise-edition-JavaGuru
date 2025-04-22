package net.aspect.education.hibernate;

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
import java.util.Map;

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

        Profile profile = Profile.builder().street("Borisova").language("ru").build();

        profile.setUser(user);

        try (SessionFactory factory = HibernateUtil.buildSessionFactory();
             Session session = factory.openSession()) {
            session.beginTransaction();

            RootGraph<User> userGraph = session.createEntityGraph(User.class);
            userGraph.addAttributeNodes("company", "userChats");
            SubGraph<UserChat> userChatsSubgraph = userGraph.addSubgraph("userChats", UserChat.class);
            userChatsSubgraph.addAttributeNodes("chat");

            Map<String, Object> properties = Map.of(
                    GraphSemantic.LOAD.getJakartaHintName(), userGraph
            );

            var userGet = session.find(User.class, 1L, properties);
            System.out.println(userGet.getCompany().getName());
            System.out.println(userGet.getUserChats().size());

            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception: ", e);
            throw e;
        }
    }
}
