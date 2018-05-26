package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.connectionManager.ConnectionManagerJDBCimpl;
import ru.innopolis.stc9.servlets.pojo.Materials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialsDAOImpl implements MaterialsDAO {
    final static Logger loggerConsoleInf = Logger.getLogger("consoleinf");
    private static ConnectionManager connectionManager = ConnectionManagerJDBCimpl.getInstance();


    @Override
    public void addMaterial(Materials material) {
        try {
            Connection connection = connectionManager.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO students (id, mname, author) VALUES" +
                            "(default,?,?)");
            statement.setString(1, material.getMname());
            statement.setString(2, material.getAurthor());
            statement.executeUpdate();
        } catch (SQLException e) {
            loggerConsoleInf.error(e.getMessage());
        }
    }


    @Override
    public Materials getMaterialbyId(int id) {
        Materials material = null;
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM materials WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                material = new Materials(
                        resultSet.getString("mname"),
                        resultSet.getString("author"));
            }

            connection.close();
        } catch (SQLException e) {
            loggerConsoleInf.error(e.getMessage());
        }
        return material;
    }


    @Override
    public void updateMaterial(Materials material) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE materials SET mname = ?,author = ? WHERE id = ?");
            statement.setString(1, material.getMname());
            statement.setString(2, material.getAurthor());
            statement.setInt(3, material.getId());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            loggerConsoleInf.error(e.getMessage());
        }
    }


    @Override
    public void deleteMaterialById(int id) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM materials WHERE  id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            loggerConsoleInf.error(e.getMessage());
        }
    }
}
