package net.aspect.education.servletapplicationedu.entity.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Gender {
    MAN,
    WOMAN;

    public static Optional<Gender> find(String gender){
        return Arrays
                .stream(values())
                .filter(it -> it.name().equals(gender))
                .findFirst();
    }
}
