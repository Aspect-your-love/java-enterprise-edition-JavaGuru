package net.aspect.education.database.entity;

import org.springframework.security.core.GrantedAuthority;

/// {@link GrantedAuthority} - реализуем данный интерфейс для того,
/// чтобы указать Spring Security, что у нас является ролями.
public enum  Role implements GrantedAuthority {
    ADMIN,
    USER,
    DEVELOPER,
    MANAGER,
    CEO;

    @Override
    public String getAuthority() {
        return name();
    }
}
