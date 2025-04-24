package net.aspect.education.hibernate;

import lombok.extern.slf4j.Slf4j;
import net.aspect.education.hibernate.entity.Payment;
import net.aspect.education.hibernate.entity.User;
import net.aspect.education.hibernate.mapper.CompanyReadMapper;
import net.aspect.education.hibernate.mapper.UserReadMapper;
import net.aspect.education.hibernate.repository.PaymentRepository;
import net.aspect.education.hibernate.repository.UserRepository;
import net.aspect.education.hibernate.service.UserService;
import net.aspect.education.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.Proxy;

@Slf4j
public class HibernateRunner {

    public static void main(String[] args) {
        try(
                SessionFactory factory = HibernateUtil.buildSessionFactory();
                ){
            //Создаём прокси объект
            var session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(),
                    new Class[]{Session.class}
                    , (proxy, method, args1) -> method.invoke(factory.getCurrentSession(), args1));
            session.beginTransaction();

            var companyReadMapper = new CompanyReadMapper();
            var userReadMapper = new UserReadMapper(companyReadMapper);
            var userRepository = new UserRepository(session);

            var userService = new UserService(userRepository, userReadMapper);

            System.out.println(userRepository.findAll());
            session.close();

        } catch(Exception e){
            log.error("Возникло исключение: {}", String.valueOf(e));
            throw e;
        }
    }
}
