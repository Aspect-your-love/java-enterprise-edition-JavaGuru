package net.aspect.education;

import net.aspect.education.config.ApplicationConfiguration;
import net.aspect.education.database.repository.UserRepository;
import net.aspect.education.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {
        System.out.println("Hello from SpringRunner.class");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);


        UserRepository ur = context.getBean(UserRepository.class);
        System.out.println(ur);

        context.close();
    }
}
