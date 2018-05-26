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
    private static ConnectionManager connectionManager = ConnectionManagerJDBCimpl.getInstance();
    final Logger loggerFileInf = Logger.getLogger("fileinf");

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
                                resultSet.getString("passwordhash"),
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


    @Override
    public void updateUserPwd(String newPassword, int uid) {
        Connection connection = connectionManager.getConnection();
        try {

            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users SET passwordhash = ?" +
                            "WHERE  id = ? ")) {
                statement.setString(1, newPassword);
                statement.setInt(2, uid);
                statement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
    }

    @Override
    public String getUserPwd(int uid) {
        String oldPasswordHash = null;
        Connection connection = connectionManager.getConnection();
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                    "passwordhash FROM users WHERE id=?")) {
                preparedStatement.setInt(1, uid);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    if (resultSet.next()) {
                        oldPasswordHash = resultSet.getString("passwordhash");
                    }
                }
            }
            connection.close();

        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return oldPasswordHash;
    }
}
