package net.aspect.education.servletapplicationedu.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<ID extends Number, T> {
    boolean update(T entity);
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    boolean delete(T entity);
}
