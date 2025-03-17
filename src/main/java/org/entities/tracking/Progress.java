package org.entities.tracking;

import org.entities.BaseEntity;

import java.time.LocalDate;

public class Progress extends BaseEntity {
    private String userId;
    private String flashcardId;
    private LocalDate lastReviewed;
    private int totalReview;
    private int correctCount;
    private double successRate;
    private LocalDate nextReviewDate;

    public Progress(String id, LocalDate timeCreated, String userId, String flashcardId, LocalDate lastReviewed,
                    int totalReview, int correctCount, double successRate, LocalDate nextReviewDate) {
        super(id, timeCreated);
        this.userId = userId;
        this.flashcardId = flashcardId;
        this.lastReviewed = lastReviewed;
        this.totalReview = totalReview;
        this.correctCount = correctCount;
        this.successRate = successRate;
        this.nextReviewDate = nextReviewDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFlashcardId() {
        return flashcardId;
    }

    public void setFlashcardId(String flashcardId) {
        this.flashcardId = flashcardId;
    }

    public LocalDate getLastReviewed() {
        return lastReviewed;
    }

    public void setLastReviewed(LocalDate lastReviewed) {
        this.lastReviewed = lastReviewed;
    }

    public int getTotalReview() {
        return totalReview;
    }

    public void setTotalReview(int totalReview) {
        this.totalReview = totalReview;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public LocalDate getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(LocalDate nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }
}