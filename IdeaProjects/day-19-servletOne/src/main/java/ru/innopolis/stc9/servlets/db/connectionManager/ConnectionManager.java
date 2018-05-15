package ru.innopolis.stc9.servlets.db.connectionManager;

import java.sql.Connection;

public interface ConnectionManager {
    public Connection getConnection();
}
