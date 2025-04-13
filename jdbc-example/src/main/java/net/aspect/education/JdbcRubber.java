package net.aspect.education;

import net.aspect.education.utils.ConnectionManager;

import java.sql.*;

public class JdbcRubber {

    public static void main(String[] args) throws SQLException {
        try (Connection open = ConnectionManager.get()) {
            /*
            DatabaseMetaData metaData = open.getMetaData();
            ResultSet catalogs = metaData.getCatalogs();
            while (catalogs.next()) System.out.println(catalogs.getString(1));*/

            String sql = "SELECT * FROM employee";
            Statement statement = open.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(sql);
            while (resultSet.next()) System.out.println(resultSet.getString("first_name"));
        }
    }
}
