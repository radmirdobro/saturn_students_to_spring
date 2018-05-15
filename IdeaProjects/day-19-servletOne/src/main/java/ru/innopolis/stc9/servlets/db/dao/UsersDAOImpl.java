package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManagerJDBCimpl;
import ru.innopolis.stc9.servlets.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersDAOImpl implements UsersDAO {
    final  Logger loggerFileInf = Logger.getLogger("fileinf");
    private static ConnectionManager connectionManager = ConnectionManagerJDBCimpl.getInstance();

    @Override
    public Users getUserByLogin(String login) {
        Users result = null;
        Connection connection = connectionManager.getConnection();
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                    "* FROM users " +
                    "WHERE login=?")) {
                preparedStatement.setString(1, login);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    if (resultSet.next()) {
                        result = new Users(
                                resultSet.getInt("id"),
                                resultSet.getString("login"),
                                resultSet.getString("passwordHash"),
                                resultSet.getInt("roles_id")
                        );
                    }
                }
            }
            connection.close();

        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return result;
    }


}
