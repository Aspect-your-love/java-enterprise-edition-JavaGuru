package net.aspect.education.hibernate;

import jakarta.persistence.Column;
import lombok.Cleanup;
import lombok.Data;
import net.aspect.education.hibernate.entity.*;
import net.aspect.education.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class HibernateRunnerTest {

    @Test
    public void checkH2Connection(){
        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        session.beginTransaction();
        /*----------------------------------------------------------*/
        Company company = Company.builder().name("Google").build();
        session.save(company);
        /*----------------------------------------------------------*/
        session.getTransaction().commit();
    }

    @Test
    @Disabled
    public void manyToManyTest(){

        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        Chat chat = Chat.builder().name("aspect_party").build();


        session.beginTransaction();
        //---------------------------------------------//
        User user = session.get(User.class, 10L);
//        user.addChat(chat);
        session.persist(chat);

        //---------------------------------------------//
        session.getTransaction().commit();
    }

    @Test
    @Disabled
    public void checkedOneToOne(){
        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        User user = User.builder()
                .username("level-up-1@developer.ru")
                .build();

        Profile profile = Profile
                .builder()
                .language("RU")
                .street("Borisova, 3")
                .build();

        session.beginTransaction();
        //---------------------------------------------//
        session.persist(user);
        profile.setUser(user);
        session.persist(profile);

        //---------------------------------------------//
        session.getTransaction().commit();
    }

    @Test
    @Disabled
    public void checkOrphalRemoval(){
        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        Company company = Company.builder()
                .name("Sterlitmah")
                .build();

        User user = User.builder()
                .username("level-up@developer.ru")
                .build();

        session.beginTransaction();
        //---------------------------------------------//

        Company companyGoogle = session.get(Company.class, 1);
        companyGoogle.getUsers().forEach(System.out::println);
        companyGoogle.getUsers().removeIf(u -> u.getId().equals(5L));

        //---------------------------------------------//
        session.getTransaction().commit();
    }

    @Test
    @Disabled
    public void addNewUserAndCompany(){
        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        Company company = Company.builder()
                .name("Sterlitmah")
                .build();

        User user = User.builder()
                .username("level-up@developer.ru")
                .build();

        session.beginTransaction();
        //---------------------------------------------//
        company.addUser(user);
        session.merge(company);

        //---------------------------------------------//
        session.getTransaction().commit();
    }

    @Test
    @Disabled
    public void checkOneToMany(){
        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        session.beginTransaction();
        //---------------------------------------------//

        Company company = session.get(Company.class, 1);
        System.out.println(company.getUsers());

        //---------------------------------------------//
        session.getTransaction().commit();
    }

    @Test
    @Disabled
    public void testHIbernateApi() throws SQLException, IllegalAccessException {
        /*User user = User.builder()
                .username("kulagin1@developer.ru")
                .firstName("Viktor")
                .lastname("Kulagin")
                .birthDate(new Birthday(LocalDate.of(2001, 1, 1)))
                .role(Role.ADMIN)
                .build();

        String sql = """
                insert into 
                %s
                (%s)
                values
                (%s)
                """;

        String tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
                .map(tabAnn -> tabAnn.schema() + "." + tabAnn.name())
                .orElse(user.getClass().getName());

        Field[] fields = user.getClass().getDeclaredFields();

        String columnName = Arrays
                .stream(fields)
                .map(field -> Optional
                        .ofNullable(field
                                .getAnnotation(Column.class))
                        .map(Column::name)
                        .orElse(field.getName()))
                .collect(Collectors.joining(", "));

        String columnValues = Arrays.stream(fields)
                .map(field -> "?")
                .collect(Collectors.joining(", "));

        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/hibernate"
                        ,"postgres"
                , "root");
        PreparedStatement preparedStatement = connection
                .prepareStatement(sql.formatted(tableName
                        , columnName
                        , columnValues));

        for(int i = 0; i < fields.length; i++){
            fields[i].setAccessible(true);
            preparedStatement.setObject(i+1, fields[i].get(user));
        }

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();*/
    }
}
