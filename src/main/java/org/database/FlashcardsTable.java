package org.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FlashcardsTable {
    public static void createFlashcardsTable(Connection connection) {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS flashcards (
                    id TEXT PRIMARY KEY,
                    front_text TEXT NOT NULL,
                    back_text TEXT NOT NULL,
                    image_path TEXT,
                    last_review TIMESTAMP,
                    review_count INTEGER DEFAULT 0,
                    difficulty INTEGER DEFAULT 0,
                    single_deck_id TEXT,
                    is_favourite INTEGER DEFAULT 0,
                    comment TEXT,
                    time_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    FOREIGN KEY (single_deck_id) REFERENCES single_decks(id) ON DELETE CASCADE
                );
                """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table 'flashcards' checked/ created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropUsersTable(Connection connection) {
        String dropTableSQL = "DROP TABLE IF EXISTS flashcards;";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropTableSQL);
            System.out.println("Table 'flashcards' deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
