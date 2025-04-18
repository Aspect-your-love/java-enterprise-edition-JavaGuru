package net.aspect.education.servletapplicationedu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {
    public static void main(String[] args) {
        try (InputStream res = TestConnection.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(res);
            String url = properties.getProperty("db.url");
            String l = properties.getProperty("db.username");
            String p = properties.getProperty("db.password");
            Connection con = DriverManager.getConnection(url, l, p);
            System.out.println(con);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
