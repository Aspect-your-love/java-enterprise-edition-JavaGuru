package net.aspect.education.servletapplicationedu.exception;

import java.util.List;
import net.aspect.education.servletapplicationedu.validator.Error;
public class ValidationException extends RuntimeException {
    private final List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
