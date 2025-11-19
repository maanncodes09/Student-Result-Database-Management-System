package com.student.result;

import java.sql.*;

public class DatabaseManager {
    private final String url = "jdbc:mysql://localhost:3306/yourDatabaseName";
    private final String user = "root";
    private final String password = "yourPassword";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void insertStudent(Student student) {
        String query = "INSERT INTO students (id, name, course) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getCourse());
            pstmt.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting student: " + e.getMessage());
        }
    }

    // Similar methods for update, delete, and get operations can be added here
}