package org.entities.cards;

import org.entities.BaseEntity;

import java.time.LocalDate;
import java.util.List;

public class Deck extends BaseEntity {
    private String name;
    private String description;
    private List<Flashcard> flashcards;
    private boolean isFavourite;
    public Deck(String id, LocalDate timeCreated, String name, String description, List<Flashcard> flashcards, boolean isFavourite) {
        super(id, timeCreated);
        this.name = name;
        this.description = description;
        this.flashcards = flashcards;
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
}
