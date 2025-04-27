package net.aspect.education;

import net.aspect.education.database.repository.UserRepository;
import net.aspect.education.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {
        System.out.println("Hello from SpringRunner.class");

        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("application.xml");

        UserRepository ur = context.getBean("ur-1", UserRepository.class);
        System.out.println(ur);

        context.close();
    }
}
