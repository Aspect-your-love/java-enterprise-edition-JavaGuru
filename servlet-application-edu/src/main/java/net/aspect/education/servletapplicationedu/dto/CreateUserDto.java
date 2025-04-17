package net.aspect.education.servletapplicationedu.dto;

public record CreateUserDto(String name, String birthday, String email, String password, String role, String gender) {
}
