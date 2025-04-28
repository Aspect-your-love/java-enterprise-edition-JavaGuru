package net.aspect.education.annotation;

import net.aspect.education.integer.TestApplicationRunner;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация предназначенная для интеграционных тестов*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles("test")
@SpringBootTest(classes = {ApplicationRunner.class, TestApplicationRunner.class})
public @interface IT {
}

class TeST{
    public native int  test();
}