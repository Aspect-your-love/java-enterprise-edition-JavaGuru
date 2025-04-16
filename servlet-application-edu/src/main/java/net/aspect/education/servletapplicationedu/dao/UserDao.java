package net.aspect.education.servletapplicationedu.dao;

import net.aspect.education.servletapplicationedu.entity.User;
import net.aspect.education.servletapplicationedu.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDao implements Dao<Long, User>{
    private static final UserDao INSTANSE = new UserDao();
    private static final String SAVE_SQL =
            "INSERT INTO users (name, birthday, email, password, role, gender) VALUES (?, ?, ?, ?, ?, ?);";

    private UserDao(){

    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public User save(User entity) {
        try(Connection connection = ConnectionManager.get()){
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole());
            preparedStatement.setObject(6, entity.getGender());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

        } catch(SQLException e){
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    public static UserDao getInstance() {
        return INSTANSE;
    }
}
