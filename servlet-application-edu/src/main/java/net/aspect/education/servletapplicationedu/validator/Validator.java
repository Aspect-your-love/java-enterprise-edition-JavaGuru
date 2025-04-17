package net.aspect.education.servletapplicationedu.validator;

public interface Validator <T> {
    ValidatorResult isValid(T t);
}
