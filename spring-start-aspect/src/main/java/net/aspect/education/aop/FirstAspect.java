package net.aspect.education.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.naming.factory.webservices.ServiceProxy;import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;import org.aspectj.lang.annotation.*;
//import org.springframework.aop.Pointcut;
import org.springframework.stereotype.Component;import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@Slf4j
public class FirstAspect {
    /**
     * Поинткат должен быть обязательно Спринг'овый.
     * Проверяем наличие аннотации @Controller
     */
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer() {
    }

    /**
     * Поинткат для проверки является ли класс сервисным.
     * Смотрим по ИМЕНИ КЛАССА
     */
    @Pointcut("within(net.aspect.education.service.*Service)")
    public void isServiceLayer() {
    }

    /**
     * Слово `this` анализирует прокси класс.
     * Слово `target` анализирует объект, на который ссылается прокси класс
     */
    @Pointcut("this(org.springframework.stereotype.Repository)")
    public void isRepositoryLayer() {
    }

    /**
     * Поинткат @annotation проверяет наличие аннотации.
     * В данном случае будет работать над всеми нашими классами, где будет данная аннотация.
     * Для того чтобы уменьшить задержки при проверке поинтката, нужно добавить `isControllerLayer()`.
     * Тогда данный поинткат будет проверять только слой контроллеров
     */
    @Pointcut("isControllerLayer() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping() {
    }

    /**
     * Проверка на то, есть ли в методах аргумент модели.
     * Также, через звёздочку указываем любой другой аргумент,
     * а через `..` любое кол-во других аргументов
     */
    @Pointcut("isControllerLayer() && args(org.springframework.ui.Model, ..)")
    public void hasModelArg() {
    }

    /**
     * @args() - проверяет наличие аннотации у метода в параметрах*/
    @Pointcut("isControllerLayer() && @args(net.aspect.education.validator.UserInfo, ..)")
    public void hasUserInfoParamAnnotation(){

    }

    /**
     * Поиск всех бинов с именем `userService*/
    @Pointcut("bean(userService)")
    public void isUserServiceBean(){
    }

    /**
     * Поиск всех сервисных бинов*/
    @Pointcut("bean(*Service)")
    public void isServiceBean(){
    }

    /**
     * Pointcut для поиска всех методов findById который возвращает параметр Long,
     * а принимает Long и любой другой параметр. Также, можем указать модификатор доступа. */
    @Pointcut("execution(public Long net.aspect.education.service.*Service.findById(Long, *))")
    public void anyServiceFindByIdMethod(){
    }

    /**
     * Поинткат для всех публичных методов, который неважно что возвращают, но имеют имя `findById()`.<br>
     * Также, данный поинткат ищет все методы с данным именам, а тип передаваемый в параметр не имеет значения*/
    @Pointcut("execution(public * findById(*))")
    public void anyFindByIdMethod(){
    }

    // Advice

    /**
     * В Advice уже передаём те PointCut, который мы создали до этого*/
    @Before("anyServiceFindByIdMethod()")
    public void addLogging() {
        log.info("Invoke findById method.");
    }

    /**
     * 1 - Указываем Поинткат;
     * 2 - Получаем доступ к аргументу id
     * 3 - Получить сам объект, который вызывается
     * 4 - Получаем ServiceProxy*/
    @Before("anyFindByIdMethod()" +
            "&& args(id)" +
            "&& target(service)" +
            "&& this(serviceProxy)" +
            "&& within(transactional)")
    public void addLoggingAdvice(JoinPoint joinPoint,
                                 Object id,
                                 Object service,
                                 Object serviceProxy,
                                 Transactional transactional) {
        log.info("Before invoke findById method in class {}, with {}", service, id);
    }

    @AfterReturning(
            value = "anyFindByIdMethod() && target(service)",
            returning = "result"
    )
    public void addLoggingAfterReturn(Object result,
                                      Object service){
        log.info("After returning. Result: {}. Class: {}", result, service);
    }

    @AfterThrowing(
            value = "anyServiceFindByIdMethod() && target(service)",
            throwing = "ex"
    )
    public void addLoggingAfterThrowing(Throwable ex, Object service){
        log.info("Was throwing in class: {}. Throwable: {}", service, ex);
    }

    @After(value = "anyServiceFindByIdMethod() && target(service)")
    public void addLoggingAfter(Object service){
        log.info("After class: {}", service);
    }

    @Around("anyServiceFindByIdMethod() && target(service) && args(id)")
    public Object addLoggingAround(ProceedingJoinPoint joinPoint, Object service, Object id) throws Throwable {
        log.info("Around before. Class: {}. Id:{}", service, id);
        try {
            Object result = joinPoint.proceed();
            log.info("Around after returning. Class: {}. Id:{}", service, id);
            return result;
        } catch (Throwable ex) {
            log.info("Around after throwing. Class: {}. Id:{}", service, id);
            throw ex;
        } finally {
            log.info("Around after (finally). Class: {}", service);
        }
    }
}
