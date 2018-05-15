package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManagerJDBCimpl;
import ru.innopolis.stc9.servlets.pojo.Timetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class TimetableDAOImpl implements TimetableDAO {
    final Logger loggerFileInf = Logger.getLogger("fileinf");
    final Logger loggerConsoleInf = Logger.getLogger("consoleinf");
    private static ConnectionManager connectionManager = ConnectionManagerJDBCimpl.getInstance();

    @Override
    public Timetable getLessonById(int id) {
        Connection connection = connectionManager.getConnection();
        Timetable lesson = null;
        try {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT  date, homework  FROM timetable WHERE id = ?")) {
                statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()) {
                        lesson = new Timetable(
                                resultSet.getString("date"),
                                resultSet.getString("homework")
                        );
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return lesson;
    }


    @Override
    public ArrayList<Timetable> getTimetableByStGID(int gid) {
        ArrayList <Timetable> subj = new ArrayList();

        Connection connection = connectionManager.getConnection();
        try {

            try (PreparedStatement statement = connection.prepareStatement("SELECT *" +
                    "FROM timetable INNER JOIN subject ON timetable.subject_id = subject.id WHERE groups_id = ? " +
                    "ORDER BY date")) {
                statement.setInt(1, gid);

                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        subj.add(new Timetable(
                                resultSet.getString("sname"),
                                resultSet.getInt("subject_id"),
                                resultSet.getString("date"),
                                resultSet.getString("time"),
                                resultSet.getString("homework"),
                                resultSet.getInt("id")
                        ));
                    }
                }
            }
            loggerFileInf.info("method StudentsDAOImpl.getStudetnbyId worked succesfully!");
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return subj;
    }
}
   