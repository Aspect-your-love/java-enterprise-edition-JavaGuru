package net.aspect.education.servletapplicationedu.entity.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Role {
    ADMIN,
    USER,
    ANON;

    public static Optional<Role> find(String role){
        return Arrays
                .stream(values())
                .filter(it -> it.name().equals(role))
                .findFirst();
    }
}
