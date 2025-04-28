package net.aspect.education.config;

import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfiguration {

    @Bean("driverPool")
    public String driverName(){
        return "DriverPoolConnectionByAspect";
    }

}
