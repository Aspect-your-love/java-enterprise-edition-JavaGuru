package net.aspect.education.annotation;

import net.aspect.education.integration.TestApplicationRunner;
import net.aspect.education.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

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
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public @interface IT {
}