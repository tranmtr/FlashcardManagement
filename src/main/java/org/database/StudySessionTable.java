package org.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudySessionTable {
    static Connection conn = DatabaseSingleton.getInstance().getConnection();

    public static void createStudySessionTable() {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS study_session (
                    id TEXT PRIMARY KEY,
                    user_id TEXT NOT NULL,
                    flashcard_id TEXT NOT NULL,
                    review_date TEXT DEFAULT CURRENT_TIMESTAMP,
                    time_spent INTEGER DEFAULT 0,
                    is_correct INTEGER DEFAULT 0,
                    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
                );
                """;
        try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
            stmt.execute();
            System.out.println("Table 'study_session' checked/ created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropStudySessionTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS study_session;";

        try (PreparedStatement stmt = conn.prepareStatement(dropTableSQL)) {
            stmt.execute();
            System.out.println("Table 'study_session' deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
