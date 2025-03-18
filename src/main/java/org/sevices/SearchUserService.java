package org.sevices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.database.DatabaseSingleton;
import org.entities.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchUserService {
    static Connection conn = DatabaseSingleton.getInstance().getConnection();

    public static ObservableList<User> searchUsersByAllParameters(
            String id, String username, String password, String name, String email, LocalDateTime timeCreated, LocalDateTime start, LocalDateTime end
    ) {
        ObservableList<User> userListSearchResult = FXCollections.observableArrayList();
        StringBuilder query = new StringBuilder(
                "SELECT id, username, password, name, email, time_created FROM users WHERE 1=1"
        );

        if (id != null && !id.isEmpty()) {
            query.append(" AND id LIKE ?");
        }
        if (username != null && !username.isEmpty()) {
            query.append(" AND username LIKE ?");
        }
        if (password != null && !password.isEmpty()) {
            query.append(" AND password LIKE ?");
        }
        if (name != null && !name.isEmpty()) {
            query.append(" AND name LIKE ?");
        }
        if (email != null && !email.isEmpty()) {
            query.append(" AND email LIKE ?");
        }
        if (timeCreated != null) {
            query.append(" AND time_created LIKE ?");
        }
        if (start != null) {
            query.append(" AND time_created >= ?");
        }
        if (end != null) {
            query.append(" AND time_created <= ?");
        }

        try (PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            if (id != null && !id.isEmpty()) {
                pstmt.setString(paramIndex++, "%" + id + "%");
            }
            if (username != null && !username.isEmpty()) {
                pstmt.setString(paramIndex++, "%" + username + "%");
            }
            if (password != null && !password.isEmpty()) {
                pstmt.setString(paramIndex++, "%" + password + "%");
            }
            if (name != null && !name.isEmpty()) {
                pstmt.setString(paramIndex++, "%" + name + "%");
            }
            if (email != null && !email.isEmpty()) {
                pstmt.setString(paramIndex++, "%" + email + "%");
            }
            if (timeCreated != null) {
                pstmt.setString(paramIndex++, timeCreated.format(formatter));
            }
            if (start != null) {
                pstmt.setString(paramIndex++, start.format(formatter));
            }
            if (end != null) {
                pstmt.setString(paramIndex++, end.format(formatter));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    User user = new User(
                            rs.getString("id"),
                            LocalDateTime.parse(rs.getString("time_created"), formatter),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                    userListSearchResult.add(user);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userListSearchResult;
    }

    public static ObservableList<User> searchUsersById(String id) {
        return searchUsersByAllParameters(id, null, null, null, null, null, null, null);
    }

    public static ObservableList<User> searchUsersByName(String name) {
        return searchUsersByAllParameters(null, null, null, name, null, null, null, null);
    }

    public static ObservableList<User> searchUsersByEmail(String email) {
        return searchUsersByAllParameters(null, null, null, null, email, null, null, null);
    }
}
