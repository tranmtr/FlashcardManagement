package org.entities.cards;

import org.entities.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flashcard extends BaseEntity {
    private String singleDeckId;
    private String frontText;
    private String backText;
    private String imagePath;
    private LocalDateTime lastReview;
    private int reviewCount;
    private int difficulty;
    private boolean isFavourite;
    private String comment;

    public Flashcard(String id, LocalDateTime timeCreated, String singleDeckId, String frontText,
                     String backText, String imagePath, LocalDateTime lastReview, int reviewCount, int difficulty, boolean isFavourite) {
        super(id, timeCreated);
        this.singleDeckId = singleDeckId;
        this.frontText = frontText;
        this.backText = backText;
        this.imagePath = imagePath;
        this.lastReview = lastReview;
        this.reviewCount = reviewCount;
        this.difficulty = difficulty;
        this.isFavourite = isFavourite;
    }

    public Flashcard(String id, LocalDateTime timeCreated, String singleDeckId, String frontText, String backText,
                     String imagePath, LocalDateTime lastReview, int reviewCount, int difficulty, boolean isFavourite, String comment) {
        super(id, timeCreated);
        this.singleDeckId = singleDeckId;
        this.frontText = frontText;
        this.backText = backText;
        this.imagePath = imagePath;
        this.lastReview = lastReview;
        this.reviewCount = reviewCount;
        this.difficulty = difficulty;
        this.isFavourite = isFavourite;
        this.comment = comment;
    }

    public String getSingleDeckId() {
        return singleDeckId;
    }

    public void setSingleDeckId(String singleDeckId) {
        this.singleDeckId = singleDeckId;
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

    public LocalDateTime getLastReview() {
        return lastReview;
    }

    public void setLastReview(LocalDateTime lastReview) {
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
