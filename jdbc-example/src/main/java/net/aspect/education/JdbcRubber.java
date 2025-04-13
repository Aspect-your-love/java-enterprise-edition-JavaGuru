package net.aspect.education;

import net.aspect.education.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcRubber {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            System.out.println(connection.getTransactionIsolation());
        }
    }
}
