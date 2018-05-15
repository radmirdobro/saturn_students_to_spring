package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManagerJDBCimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupsDAOImpl implements GroupsDAO{
    final Logger loggerFileInf = Logger.getLogger("fileinf");
    private static ConnectionManager connectionManager = ConnectionManagerJDBCimpl.getInstance();


    @Override
    public String getStGroupById(int id) {
        String gname = null;
        Connection connection = connectionManager.getConnection();
        try {

            try (PreparedStatement statement = connection.prepareStatement("SELECT gname FROM groups WHERE id = ? ")) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        gname = resultSet.getString("gname");
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return gname;
    }
}
