package net.aspect.education.servletapplicationedu.validator;

import java.util.Objects;

public class Error {
    private final String code;
    private final String message;

    private Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Error of(String code, String message) {
        return new Error(code, message);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Error error)) return false;
        return Objects.equals(code, error.code) && Objects.equals(message, error.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "Error{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
