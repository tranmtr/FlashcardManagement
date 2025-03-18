package org.database;

import org.entities.user.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UsersTable {
    static Connection conn = DatabaseSingleton.getInstance().getConnection();

    public static void createUsersTable() {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS users (
                    id TEXT PRIMARY KEY,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    name TEXT NOT NULL,
                    email TEXT NOT NULL,
                    time_created TEXT DEFAULT CURRENT_TIMESTAMP
                );
                """;
        try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
            stmt.execute();
            System.out.println("Table 'users' checked/ created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertUser(User user) throws SQLException {
        if (conn == null || conn.isClosed()) {
            throw new SQLException("Cannot insert user, connection is closed or invalid.");
        }

        // Kiểm tra xem user đã tồn tại chưa
        String checkSQL = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkSQL)) {
            checkStmt.setString(1, user.getUsername());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("User already exists in the database.");
                return;
            }
        }

        // Thêm user nếu chưa tồn tại
        String insertSQL = "INSERT INTO users (id, username, password, name, email, time_created) VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
        try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
            insertStmt.setString(1, user.getId());
            insertStmt.setString(2, user.getUsername());
            insertStmt.setString(3, user.getPassword());
            insertStmt.setString(4, user.getName());
            insertStmt.setString(5, user.getEmail());
            insertStmt.executeUpdate();
            System.out.println("User inserted successfully.");
        }
    }

    public static void getUserById(String userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) { // Nếu tìm thấy user
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            LocalDateTime time_created = resultSet.getTimestamp("time_created").toLocalDateTime();
            System.out.println("User Found: ID: " + userId + ", Name: " + name + ", Email: " + email + ", Time: " + time_created);
        } else {
            System.out.println("User not found with ID: " + userId);
        }
    }

    public static void dropUsersTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS users;";

        try (PreparedStatement stmt = conn.prepareStatement(dropTableSQL)) {
            stmt.execute();
            System.out.println("Table 'users' deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
