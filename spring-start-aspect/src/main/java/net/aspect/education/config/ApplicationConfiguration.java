package net.aspect.education.config;

import org.springframework.context.annotation.*;

//@Import(Conf.class) //Внедрение конфигурации из другого модуля
@ImportResource("application.xml") //Добавление XML конфигурации
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("net.aspect.education")
@Profile("!prod")
public class ApplicationConfiguration {

    @Bean("driverPool")
    public String driverName(){
        return "DriverPoolConnectionByAspect";
    }

}
