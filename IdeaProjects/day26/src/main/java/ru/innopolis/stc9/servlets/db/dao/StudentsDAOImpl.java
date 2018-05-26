package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManagerJDBCimpl;
import ru.innopolis.stc9.servlets.pojo.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentsDAOImpl implements StudentsDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCimpl.getInstance();
    final Logger loggerFileInf = Logger.getLogger("fileinf");
    final Logger loggerConsoleInf = Logger.getLogger("consoleinf");

    @Override
    public void addStudent(Students student) {
        try {
            Connection connection = connectionManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO students (id, name, age, adres, phone, email) VALUES" +
                            "(default,?,?,?,?,?,?,?)")) {
                statement.setString(1, student.getName());
                statement.setInt(2, student.getAge());
                statement.setString(3, student.getAdres());
                statement.setString(4, student.getPhone());
                statement.setString(5, student.getEmail());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
    }

    @Override
    public Students getStudentbyUID(int uid) {
        Students student = null;
        Connection connection = connectionManager.getConnection();
        try {

            try (PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM students  INNER JOIN groups ON students.groups_id = groups.id WHERE users_id = ?")) {
                statement.setInt(1, uid);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        student = new Students(
                                resultSet.getString("name"),
                                resultSet.getInt("age"),
                                resultSet.getString("adres"),
                                resultSet.getString("phone"),
                                resultSet.getString("email"),
                                resultSet.getString("gname"),
                                resultSet.getInt("course")
                        );
                    }
                }
            }
            loggerFileInf.info("method StudentsDAOImpl.getStudetnbyId worked succesfully!");
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return student;
    }


    @Override
    public int getStGIDByUID(int uid) {
        int gid = 0;
        Connection connection = connectionManager.getConnection();
        try {

            try (PreparedStatement statement = connection.prepareStatement("SELECT groups_id " +
                    "FROM students  WHERE users_id = ?")) {
                statement.setInt(1, uid);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        gid = resultSet.getInt("groups_id");

                    }
                }
            }
            loggerFileInf.info("method StudentsDAOImpl.getStudetnbyId worked succesfully!");
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return gid;
    }

    @Override
    public int getStudentIDbyUID(int uid) {
        int sid = 0;
        Connection connection = connectionManager.getConnection();
        try {

            try (PreparedStatement statement = connection.prepareStatement("SELECT id " +
                    "FROM students  WHERE users_id = ?")) {
                statement.setInt(1, uid);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        sid = resultSet.getInt("id");

                    }
                }
            }
            loggerFileInf.info("method StudentsDAOImpl.getStudetnbyId worked succesfully!");
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
        return sid;
    }

    @Override
    public void updateStudent(Students student) {
        try {
            Connection connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE students SET name = ?,age = ?,adres = ?,phone = ?,email = ?" +
                            " WHERE id = ?")) {
                statement.setString(1, student.getName());
                statement.setInt(2, student.getAge());
                statement.setString(3, student.getAdres());
                statement.setString(4, student.getPhone());
                statement.setString(5, student.getEmail());
                statement.setInt(6, student.getId());
                statement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
    }

    @Override
    public void deleteStudentById(int id) {
        try {
            Connection connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM students WHERE  id = ?")) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        }
    }

    @Override
    public ArrayList<Students> getStudentList() {
        ArrayList<Students> students = new ArrayList();
        try {
            Connection connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM students  INNER JOIN groups ON students.groups_id = groups.id")) {

                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        students.add(new Students(
                                resultSet.getString("name"),
                                resultSet.getInt("age"),
                                resultSet.getString("adres"),
                                resultSet.getString("phone"),
                                resultSet.getString("email"),
                                resultSet.getString("gname"),
                                resultSet.getInt("course")
                        ));
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
            loggerFileInf.error(e.getMessage());
        } catch (NullPointerException e) {
            loggerFileInf.error(e.getMessage());
        }
        return students;
    }
}
