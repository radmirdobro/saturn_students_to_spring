package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManagerJDBCimpl;
import ru.innopolis.stc9.servlets.pojo.HomeWorks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HomeWorksDAOImpl implements HomeWorksDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCimpl.getInstance();
    final Logger loggerFileInf = Logger.getLogger("fileinf");
    final Logger loggerConsoleInf = Logger.getLogger("consoleinf");

    @Override
    public void addHomeWork(HomeWorks homework) {
        Connection connection = connectionManager.getConnection();
        try {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO homeworks" +
                    " (decision, file, student_id, timetable_id) " +
                    "VALUES (?,?,?,?)")) {
                statement.setString(1, homework.getDecision());
                statement.setString(2, homework.getHwfile());
                statement.setInt(3, homework.getStudent_id());
                statement.setInt(4, homework.getTimetable_id());
                statement.executeUpdate();
            }
            loggerConsoleInf.info("method addHomeWork worked succesfully!");
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
    }

    @Override
    public void updateHomeWork(HomeWorks homework) {
        Connection connection = connectionManager.getConnection();
        try {

            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE homeworks SET decision = ?, file = ?" +
                            "WHERE  timetable_id = ? AND student_id = ?")) {
                statement.setString(1, homework.getDecision());
                statement.setString(2, homework.getHwfile());
                statement.setInt(3, homework.getTimetable_id());
                statement.setInt(4, homework.getStudent_id());
                statement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
    }

    @Override
    public HomeWorks getHomeWorkAnswer(int timetable_id, int student_id) {
        Connection connection = connectionManager.getConnection();
        HomeWorks hwanswer = null;
        try {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT  decision, file  FROM homeworks WHERE " +
                            "timetable_id = ? AND student_id = ?")) {
                statement.setInt(1, timetable_id);
                statement.setInt(2, student_id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        hwanswer = new HomeWorks(
                                resultSet.getString("decision"),
                                resultSet.getString("file")
                        );
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return hwanswer;
    }

    public boolean isHomeWorkEmpty(int timetable_id, int student_id) {
        Connection connection = connectionManager.getConnection();
        try {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT id FROM homeworks WHERE " +
                            "timetable_id = ? AND student_id = ?")) {
                statement.setInt(1, timetable_id);
                statement.setInt(2, student_id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return false;
                    }
                }
                statement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return true;
    }

}
