package net.aspect.education.servletapplicationedu.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorResult {
    private final List<Error> errors = new ArrayList<>();

    public boolean isValid() {
        return errors.isEmpty();
    }

    public void add(Error error){
        errors.add(error);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
