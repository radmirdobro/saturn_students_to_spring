package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManagerJDBCimpl;
import ru.innopolis.stc9.servlets.pojo.Subject;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {
    final Logger loggerFileInf = Logger.getLogger("fileinf");
    final Logger loggerConsoleInf = Logger.getLogger("consoleinf");
    private static ConnectionManager connectionManager = ConnectionManagerJDBCimpl.getInstance();


    @Override
    public ArrayList getAllSubjects() {
        ArrayList<Subject> subjects = new ArrayList();

        Connection connection = connectionManager.getConnection();
        try {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT id, sname FROM subject")) {
                    while (resultSet.next()) {
                        subjects.add(new Subject(
                                resultSet.getInt("id"),
                                resultSet.getString("sname"),
                                0,
                                0
                        ));
                    }
                }
            }
            loggerFileInf.info("method  getSubjects() worked succesfully!");
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return subjects;
    }

    @Override
    public String getSubjectNameById(int sid) {
        Connection connection = connectionManager.getConnection();
        String subject_name = null;
        try {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT  sname  FROM subject WHERE id = ?")) {
                statement.setInt(1, sid);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        subject_name = resultSet.getString("sname");
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());

        }
        return subject_name;
    }
}
