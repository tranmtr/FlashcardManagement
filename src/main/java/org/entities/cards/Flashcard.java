package org.entities.cards;

import org.entities.BaseEntity;

import java.time.LocalDate;

public class Flashcard extends BaseEntity {
    private String deckId;
    private String frontText;
    private String backText;
    private String imagePath;
    private LocalDate lastReview;
    private int reviewCount;
    private int difficulty;
    private boolean isFavourite;
    private String comment;

    public Flashcard(String id, LocalDate timeCreated, String deckId, String frontText,
                     String backText, String imagePath, LocalDate lastReview, int reviewCount, int difficulty, boolean isFavourite) {
        super(id, timeCreated);
        this.deckId = deckId;
        this.frontText = frontText;
        this.backText = backText;
        this.imagePath = imagePath;
        this.lastReview = lastReview;
        this.reviewCount = reviewCount;
        this.difficulty = difficulty;
        this.isFavourite = isFavourite;
    }

    public Flashcard(String id, LocalDate timeCreated, String deckId, String frontText, String backText,
                     String imagePath, LocalDate lastReview, int reviewCount, int difficulty, boolean isFavourite, String comment) {
        super(id, timeCreated);
        this.deckId = deckId;
        this.frontText = frontText;
        this.backText = backText;
        this.imagePath = imagePath;
        this.lastReview = lastReview;
        this.reviewCount = reviewCount;
        this.difficulty = difficulty;
        this.isFavourite = isFavourite;
        this.comment = comment;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public String getFrontText() {
        return frontText;
    }

    public void setFrontText(String frontText) {
        this.frontText = frontText;
    }

    public String getBackText() {
        return backText;
    }

    public void setBackText(String backText) {
        this.backText = backText;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LocalDate getLastReview() {
        return lastReview;
    }

    public void setLastReview(LocalDate lastReview) {
        this.lastReview = lastReview;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
