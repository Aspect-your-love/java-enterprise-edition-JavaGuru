package net.aspect.education.servletapplicationedu.entity;

import net.aspect.education.servletapplicationedu.entity.enums.Gender;
import net.aspect.education.servletapplicationedu.entity.enums.Role;
import java.time.LocalDate;
import java.util.Objects;

public class User {
    private Integer id;
    private String name;
    private LocalDate birthday;
    private String email;
    private String password;
    private Role role;
    private Gender gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && role == user.role && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, email, password, role, gender);
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", birthday=" + birthday +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", role=" + role +
               ", gender=" + gender +
               '}';
    }
}
