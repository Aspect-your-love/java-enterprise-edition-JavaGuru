package net.aspect.education.hibernate.dao;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.aspect.education.hibernate.entity.QCompany;
import net.aspect.education.hibernate.entity.QUser;
import net.aspect.education.hibernate.entity.User;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {
    private static UserDao INSTANCE = new UserDao();

    public static UserDao getInstance() {
        return INSTANCE;
    }

    public List<User> findAll(Session session) {
        JPAQuery<User> userJPAQuery = new JPAQuery<>(session); //1
        JPAQuery<User> users = userJPAQuery.select(QUser.user).from(QUser.user); //2
        return users.fetch(); //3
    }

    /**
     * Находим всех пользователей по имени
     */
    public List<User> findByFirstName(Session session, String firstName) {

        return new JPAQuery<User>(session)
                .select(QUser.user)
                .from(QUser.user)
                .where(QUser.user.personalInfo().firstname.eq(firstName))
                .fetch();
    }

    /**
     * Возвращает первые {limit} сотрудников, упорядоченных по дате рождения (в порядке возрастания).
     * Пример использования `ORDER BY`
     */
    private List<User> findLimitedUsersOrderByBirthday(Session session, int limit) {
        return new JPAQuery<User>(session).select(QUser.user).from(QUser.user)
                .orderBy(
                        new OrderSpecifier(
                                Order.ASC
                                , QUser.user
                                .personalInfo()
                                .birthDate))
                .limit(limit).fetch();
    }

    /**
     * Выбираем всех сотрудников, которые работают в companyName.
     * Пример использования JOIN*/
    public List<User> findAllByCompanyName(Session session, String companyName) {
        return new JPAQuery<User>(session).select(QUser.user)
                .from(QCompany.company)
                .join(QCompany.company.users, QUser.user)
                .where(QCompany.company.name.eq(companyName))
                .fetch();
    }


    /*public List<Tuple> findCompanyNamewWithAvgUserPaymentsOrderedByCompanyName(Session session){

        return new JPAQuery<Tuple>(session)
                .select(QCompany.company, QUser.user.payments.amount.avg())
                .from(QCompany.company)
                .join(QCompany.company.users, QUser.user)
                .join(QUser.user.payments, QUser.user.payments)
                .groupBy(QCompany.company.name)
                .orderBy(QCompany.company.name.asc())
                .fetch();
    }*/
}
