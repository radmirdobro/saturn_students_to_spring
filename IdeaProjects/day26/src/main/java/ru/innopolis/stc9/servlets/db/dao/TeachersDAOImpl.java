package ru.innopolis.stc9.servlets.db.dao;


import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManagerJDBCimpl;
import ru.innopolis.stc9.servlets.pojo.Teachers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeachersDAOImpl implements TeachersDAO {
    final static Logger loggerConsoleInf = Logger.getLogger("consoleinf");
    private static ConnectionManager connectionManager = ConnectionManagerJDBCimpl.getInstance();

    @Override
    public boolean checkForduplicate(Teachers teacher) {
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM teachers WHERE name = ? AND email = ? INNER JOIN users ON teachers.id = teachers.id WHERE" +
                    "teachers.id = ?");
            statement.setString(1, teacher.getName());
            statement.setString(2, teacher.getEmail());
            statement.setInt(3, teacher.getUsers_id());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                loggerConsoleInf.info("the same Teacher was found. id:" + resultSet.getString("id"));
                return true;
            }

            connection.close();
        } catch (SQLException e) {
            loggerConsoleInf.error(e.getMessage());
        }
        return false;
    }

    @Override
    public void addTeacher(Teachers teacher) {
        try {
            Connection connection = connectionManager.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO teachers (id, name, adres, phone, email, subject_id, status) VALUES" +
                            "(default,?,?,?,?,?,?,?,?)");
            statement.setString(1, teacher.getName());
            statement.setString(4, teacher.getAdres());
            statement.setString(5, teacher.getPhone());
            statement.setString(6, teacher.getEmail());
            statement.setInt(7, teacher.getSubject_id());
            statement.setString(8, teacher.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            loggerConsoleInf.error(e.getMessage());
        }
    }

    @Override
    public Teachers getTeacherbyId(int id) {
        Teachers teacher = null;
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM teachers WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                teacher = new Teachers(
                        resultSet.getString("name"),
                        resultSet.getString("adres"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getInt("subject_id"),
                        resultSet.getString("status"));
            }

            connection.close();
        } catch (SQLException e) {
            loggerConsoleInf.error(e.getMessage());
        }
        return teacher;
    }

    @Override
    public void updateTeacher(Teachers teacher) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE teachers SET name = ?,login = ?, password = ?, adres = ?, phone = ?,email = ?" +
                            ",subject_id = ?, status = ? WHERE id = ?");
            statement.setString(1, teacher.getName());
            statement.setString(4, teacher.getAdres());
            statement.setString(5, teacher.getPhone());
            statement.setString(6, teacher.getEmail());
            statement.setInt(7, teacher.getSubject_id());
            statement.setString(8, teacher.getStatus());
            statement.setInt(9, teacher.getId());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            loggerConsoleInf.error(e.getMessage());
        }
    }

    @Override
    public void deleteTeacherById(int id) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM teachers WHERE  id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            loggerConsoleInf.error(e.getMessage());
        }
    }
}
