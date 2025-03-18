package org.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeckGroupsTable {
    static Connection conn = DatabaseSingleton.getInstance().getConnection();

    public static void createDeckGroupsTable() {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS deck_groups (
                    id TEXT PRIMARY KEY,
                    name TEXT NOT NULL,
                    description TEXT,
                    parent_id TEXT,
                    user_id TEXT NOT NULL,
                    is_favourite INTEGER DEFAULT 0,
                    time_created TEXT DEFAULT CURRENT_TIMESTAMP,
                    FOREIGN KEY (parent_id) REFERENCES deck_groups(id) ON DELETE CASCADE,
                    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
                );
                """;
        try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
            stmt.execute();
            System.out.println("Table 'deck_groups' checked/ created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropUsersTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS deck_groups;";

        try (PreparedStatement stmt = conn.prepareStatement(dropTableSQL)) {
            stmt.execute();
            System.out.println("Table 'deck_groups' deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
