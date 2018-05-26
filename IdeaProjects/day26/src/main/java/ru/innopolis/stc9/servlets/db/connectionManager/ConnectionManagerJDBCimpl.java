package ru.innopolis.stc9.servlets.db.connectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJDBCimpl implements ConnectionManager {
    private static ConnectionManager connectionManager;

    private ConnectionManagerJDBCimpl() {

    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerJDBCimpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/students_marks",
                    "postgres",
                    "23itV02#");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

