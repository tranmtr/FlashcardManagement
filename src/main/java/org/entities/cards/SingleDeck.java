package org.entities.cards;

import org.entities.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SingleDeck extends BaseEntity implements DeckComponent {
    private String name;
    private String description;
    private String parentId;
    private String userId;
    private List<Flashcard> flashcards;
    private boolean isFavourite;

    public SingleDeck(String id, LocalDateTime timeCreated, String name, String description,
                      String parentId, String userId, List<Flashcard> flashcards, boolean isFavourite) {
        super(id, timeCreated);
        this.name = name;
        this.description = description;
        this.parentId = parentId;
        this.userId = userId;
        if (flashcards == null) {
            this.flashcards = new ArrayList<Flashcard>();
        } else {
            this.flashcards = flashcards;
        }
        this.isFavourite = isFavourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    public void removeFlashcard(Flashcard flashcard) {
        flashcards.remove(flashcard);
    }

    public String getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public void show() {
        System.out.println("Deck: " + this.name);
    }
}
