package net.aspect.education.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("net.aspect.education")
public class ApplicationConfiguration {

    @Bean("driverPool")
    public String driverName(){
        return "DriverPoolConnectionByAspect";
    }

}
