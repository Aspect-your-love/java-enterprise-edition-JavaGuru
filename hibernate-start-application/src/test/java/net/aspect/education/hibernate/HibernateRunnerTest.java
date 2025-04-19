package net.aspect.education.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import net.aspect.education.hibernate.start.entity.Birthday;
import net.aspect.education.hibernate.start.entity.Role;
import net.aspect.education.hibernate.start.entity.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class HibernateRunnerTest {

    /*@Test
    public void testHIbernateApi() throws SQLException, IllegalAccessException {
        User user = User.builder()
                .username("kulagin1@developer.ru")
                .firstName("Viktor")
                .lastname("Kulagin")
                .birthDate(new Birthday(LocalDate.of(2001, 1, 1)))
                .role(Role.ADMIN)
                .build();

        String sql = """
                insert into 
                %s
                (%s)
                values
                (%s)
                """;

        String tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
                .map(tabAnn -> tabAnn.schema() + "." + tabAnn.name())
                .orElse(user.getClass().getName());

        Field[] fields = user.getClass().getDeclaredFields();

        String columnName = Arrays
                .stream(fields)
                .map(field -> Optional
                        .ofNullable(field
                                .getAnnotation(Column.class))
                        .map(Column::name)
                        .orElse(field.getName()))
                .collect(Collectors.joining(", "));

        String columnValues = Arrays.stream(fields)
                .map(field -> "?")
                .collect(Collectors.joining(", "));

        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/hibernate"
                        ,"postgres"
                , "root");
        PreparedStatement preparedStatement = connection
                .prepareStatement(sql.formatted(tableName
                        , columnName
                        , columnValues));

        for(int i = 0; i < fields.length; i++){
            fields[i].setAccessible(true);
            preparedStatement.setObject(i+1, fields[i].get(user));
        }

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }*/
}
