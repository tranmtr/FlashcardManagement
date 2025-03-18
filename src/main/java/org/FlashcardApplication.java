package org;

import org.database.*;
import org.entities.cards.DeckComponent;
import org.entities.cards.DeckGroup;
import org.entities.cards.Flashcard;
import org.entities.cards.SingleDeck;
import org.entities.user.User;
import org.study_mode.StudyMode;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

public class FlashcardApplication {
    public static void main(String[] args) throws SQLException {

        // Lấy instance duy nhất của database
        DatabaseSingleton db = DatabaseSingleton.getInstance();

        // Lấy kết nối từ instance này
        Connection conn = db.getConnection();

        if (conn != null) {
            UsersTable.createUsersTable();
            DeckGroupsTable.createDeckGroupsTable();
            SingleDecksTable.createSingleDecksTable();
            FlashcardsTable.createFlashcardsTable();
            StudySessionTable.createStudySessionTable();
            System.out.println("Kết nối thành công!");
        } else {
            System.out.println("Kết nối thất bại!");
        }

        //LocalDateTime now = LocalDateTime.now();
        //UsersTable.getUserById("0002", conn);
        //User user = new User("0002", now, "A", "123", "DTA", "@@@");
        //UsersTable.insertUser(user, conn);

        /*
        LocalDateTime now = LocalDateTime.now();
        Flashcard flashcard = new Flashcard("1", now, "1", "22", "ajkfhka", "sau", null, now, 10, 5, false);
        SingleDeck singleDeck = new SingleDeck("1", now, "HEHE", "JJJ", "55", "22", null, false);
        singleDeck.addFlashcard(flashcard);
        DeckGroup deckGroup = new DeckGroup("55", now, "DJKDNDKNSNSKNSDK", "akjlfnknd", null, "22", null, false);
        DeckGroup deckGroup2 = new DeckGroup("56", now, "DJKDNDKNSNSKNSDK", "akjlfnknd", "55", "22", null, false);

        deckGroup.addDeck(singleDeck);
        deckGroup.addDeck(deckGroup2);

        for (DeckComponent deckComponent:deckGroup.getComponents()) {
            if (deckComponent instanceof SingleDeck) {
                SingleDeck singleDeck1 = (SingleDeck) deckComponent;
                List<Flashcard> flashcards = singleDeck1.getFlashcards();

                if (flashcards != null && !flashcards.isEmpty()) {
                    System.out.println(flashcards.get(0).getTimeCreated());
                } else {
                    System.out.println("Danh sách flashcards bị null hoặc rỗng!");
                }
            }
        }
        */

    }
}