package org.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SingleDecksTable {
    public static void createSingleDecksTable(Connection connection) {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS single_decks (
                    id TEXT PRIMARY KEY,
                    name TEXT NOT NULL,
                    description TEXT,
                    parent_id TEXT,
                    is_favourite INTEGER DEFAULT 0,
                    time_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    FOREIGN KEY (parent_id) REFERENCES deck_groups(id) ON DELETE CASCADE
                );
                """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table 'single_decks' checked/ created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropUsersTable(Connection connection) {
        String dropTableSQL = "DROP TABLE IF EXISTS single_decks;";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSQL);
            System.out.println("Table 'single_decks' deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
