package net.aspect.education;

import net.aspect.education.utils.ConnectionManager;

import java.sql.*;

public class JdbcRubber {

    public static void main(String[] args) throws SQLException {
        try(Connection open = ConnectionManager.open()){
            DatabaseMetaData metaData = open.getMetaData();
            ResultSet catalogs = metaData.getCatalogs();
            while(catalogs.next()) System.out.println(catalogs.getString(1));
        }
    }
}
