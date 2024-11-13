package org.example.service;

import org.example.model.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StudentService{
    private Connection connection;

    public StudentService(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
    }

    public void createTable()
    {
        String sql = "create if not exists table Students (id Primary key integer, name character(100), surname character(100),email character(100))";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            sql = "insert into Students values (?,?,?,?)";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Optional<List<Student>> findAll() {
        return Optional.empty();
    }

    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }
}
