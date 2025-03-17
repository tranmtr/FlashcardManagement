package org.database;

import org.entities.cards.SingleDeck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
    private static final String URL = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\main\\resources\\org\\database\\flashcard.db";
    private static DatabaseSingleton instance;
    private Connection connection;

    private DatabaseSingleton() {
        try {
            connection = DriverManager.getConnection(URL);
            UsersTable.createUsersTable(connection);
            DeckGroupsTable.createDeckGroupsTable(connection);
            SingleDecksTable.createSingleDecksTable(connection);
            FlashcardsTable.createFlashcardsTable(connection);

            System.out.println("Ket noi SQLite thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
