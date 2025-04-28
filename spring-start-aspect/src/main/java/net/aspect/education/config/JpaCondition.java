package net.aspect.education.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class JpaCondition implements Condition {
    /**
     * Если данный метод выдаст true, то это говорит о необходимости подтягивания
     * JpaConfig
     * Если нет драйвера для PostgreSQL, то и не будет подтянут конфиг*/
    @Override
    @SuppressWarnings("all")
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try{
            context.getClassLoader().loadClass("org.postgresql.Driver");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
