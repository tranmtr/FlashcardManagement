package org.entities.tracking;

import org.entities.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StudySession extends BaseEntity {
    private String userId;
    private String flashcardId;
    private LocalDate reviewDate;
    private int timeSpent;
    private boolean isCorrect;

    public StudySession(String id, LocalDateTime timeCreated, String userId, String flashcardId,
                        LocalDate reviewDate, int timeSpent, boolean isCorrect) {
        super(id, timeCreated);
        this.userId = userId;
        this.flashcardId = flashcardId;
        this.reviewDate = reviewDate;
        this.timeSpent = timeSpent;
        this.isCorrect = isCorrect;
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

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
