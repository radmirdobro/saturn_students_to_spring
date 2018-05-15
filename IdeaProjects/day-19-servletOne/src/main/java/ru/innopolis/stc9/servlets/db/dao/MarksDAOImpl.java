package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManagerJDBCimpl;
import ru.innopolis.stc9.servlets.pojo.Marks;
import ru.innopolis.stc9.servlets.pojo.Students;

import java.sql.*;
import java.util.ArrayList;

public class MarksDAOImpl implements MarksDAO {
    final Logger loggerFileInf = Logger.getLogger("fileinf");
    final Logger loggerConsoleInf = Logger.getLogger("consoleinf");
    private static ConnectionManager connectionManager = ConnectionManagerJDBCimpl.getInstance();

    @Override
    public void addMark(Marks mark) {

    }

    @Override
    public Marks getStudentMarksbySubject(int student_id, int subject_id) {
        return null;
    }

    @Override
    public void updateMark(Marks mark) {

    }



    @Override
    public ArrayList<Marks> getStMarkForSubject(int student_id) {
        ArrayList<Marks> marks = new ArrayList();

        Connection connection = connectionManager.getConnection();
        try {
            try (PreparedStatement statement = connection.prepareStatement("SELECT attendance, mark," +
                    "subject_id FROM marks INNER JOIN timetable ON marks.timetable_id = timetable.id WHERE student_id = ?")) {
                statement.setInt(1, student_id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        marks.add(new Marks(
                                resultSet.getString("attendance"),
                                resultSet.getInt("mark"),
                                resultSet.getInt("subject_id")
                        ));
                    }
                }
            }
            loggerFileInf.info("method  getStTotalMarkForSubject worked succesfully!");
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return marks;
    }
}

