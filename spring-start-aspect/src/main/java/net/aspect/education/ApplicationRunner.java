package net.aspect.education;

import net.aspect.education.config.DataBasePropertiesYML;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "net.aspect.education")
@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(context.getBean(DataBasePropertiesYML.class));
    }
}
