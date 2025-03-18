package org.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class FlashcardsTable {
    static Connection conn = DatabaseSingleton.getInstance().getConnection();

    public static void createFlashcardsTable() {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS flashcards (
                    id TEXT PRIMARY KEY,
                    front_text TEXT NOT NULL,
                    back_text TEXT NOT NULL,
                    image_path TEXT,
                    last_review TEXT,
                    review_count INTEGER DEFAULT 0,
                    difficulty INTEGER DEFAULT 0,
                    single_deck_id TEXT NOT NULL,
                    user_id TEXT NOT NULL,
                    is_favourite INTEGER DEFAULT 0,
                    comment TEXT,
                    time_created TEXT DEFAULT CURRENT_TIMESTAMP,
                    FOREIGN KEY (single_deck_id) REFERENCES single_decks(id) ON DELETE CASCADE,
                    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
                );
                """;
        try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
            stmt.execute();
            System.out.println("Table 'flashcards' checked/ created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropUsersTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS flashcards;";

        try (PreparedStatement stmt = conn.prepareStatement(dropTableSQL)) {
            stmt.execute();
            System.out.println("Table 'flashcards' deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
