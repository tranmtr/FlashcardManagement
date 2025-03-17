package org.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersTable {
    public static void createUsersTable(Connection connection) {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS users (
                    id TEXT PRIMARY KEY,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    name TEXT NOT NULL,
                    email TEXT NOT NULL,
                    time_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                );
                """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table 'users' checked/ created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropUsersTable(Connection connection) {
        String dropTableSQL = "DROP TABLE IF EXISTS users;";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSQL);
            System.out.println("Table 'users' deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
