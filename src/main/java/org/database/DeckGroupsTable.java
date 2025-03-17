package org.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeckGroupsTable {
    public static void createDeckGroupsTable(Connection connection) {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS deck_groups (
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
            System.out.println("Table 'deck_groups' checked/ created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropUsersTable(Connection connection) {
        String dropTableSQL = "DROP TABLE IF EXISTS deck_groups;";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSQL);
            System.out.println("Table 'deck_groups' deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
