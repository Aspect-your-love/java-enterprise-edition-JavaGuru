package net.aspect.education.servletapplicationedu.dao;

import net.aspect.education.servletapplicationedu.entity.User;
import net.aspect.education.servletapplicationedu.entity.enums.Gender;
import net.aspect.education.servletapplicationedu.entity.enums.Role;
import net.aspect.education.servletapplicationedu.utils.ConnectionManager;
import net.aspect.education.servletapplicationedu.utils.LocalDateFormatter;

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
    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL =
            """
                    SELECT 
                      * 
                    FROM
                      users
                    WHERE
                      email = ?
                      AND
                      password = ?;
                    """;

    private UserDao(){

    }

    public Optional<User> getByEmailAndPassword(String email, String password){
        try(Connection connection = ConnectionManager.get()){
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL, RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, email);
            preparedStatement.setObject(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            User retUser = null;
            if(resultSet.next()){
                retUser = new User();
                retUser.setId(resultSet.getInt("id"));
                retUser.setName(resultSet.getString("name"));
                retUser.setBirthday(LocalDateFormatter.format(resultSet.getDate("birthday").toString()));
                retUser.setEmail(resultSet.getString("email"));
                retUser.setPassword(resultSet.getString("password"));
                retUser.setRole(Role.valueOf(resultSet.getString("Role")));
                retUser.setGender(Gender.valueOf(resultSet.getString("gender")));
            }

            return Optional.ofNullable(retUser);

        } catch(SQLException e){
            e.printStackTrace();
            return Optional.empty();
        }

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
            preparedStatement.setObject(5, entity.getRole().toString());
            preparedStatement.setObject(6, entity.getGender().toString());

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
