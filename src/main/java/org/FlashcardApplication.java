package org;

import org.database.DatabaseSingleton;
import org.database.UsersTable;
import org.study_mode.StudyMode;

import java.sql.Connection;

public class FlashcardApplication {
    public static void main(String[] args) {
        // Lấy instance duy nhất của database
        DatabaseSingleton db = DatabaseSingleton.getInstance();

        // Lấy kết nối từ instance này
        Connection conn = db.getConnection();

        if (conn != null) {
            System.out.println("Kết nối thành công!");
        } else {
            System.out.println("Kết nối thất bại!");
        }
    }
}