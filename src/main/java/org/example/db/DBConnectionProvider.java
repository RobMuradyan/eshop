package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {
    private static DBConnectionProvider dbConnectionProvider = null;
    private Connection connection;

    private DBConnectionProvider() {
    }

    private static String DB_URL = "jdbc:mysql://localhost:3306";
    private static String DB_username = "root";
    private static String DB_password = "root";

    public synchronized static DBConnectionProvider getInstance() {
        if (dbConnectionProvider == null) {
            dbConnectionProvider = new DBConnectionProvider();
        }
        return dbConnectionProvider;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, DB_username, DB_password);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
}
