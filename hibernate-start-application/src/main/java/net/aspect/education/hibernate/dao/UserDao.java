package net.aspect.education.hibernate.dao;

import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.aspect.education.hibernate.entity.QUser;
import net.aspect.education.hibernate.entity.User;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class UserDao {
    private static UserDao INSTANCE = new UserDao();

    public static UserDao getInstance() {
        return INSTANCE;
    }

    public List<User> findAll(Session session){
        JPAQuery<User> userJPAQuery = new JPAQuery<>(session); //1
        JPAQuery<User> users = userJPAQuery.select(QUser.user).from(QUser.user); //2
        return users.fetch(); //3
    }

    public List<User> findByFirstName(Session session, String firstName){

        return List.of(); //5
    }
}
