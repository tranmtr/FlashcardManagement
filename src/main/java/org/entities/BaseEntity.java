package org.entities;

import java.time.LocalDate;

public abstract class BaseEntity {
    private String id;
    private LocalDate timeCreated;

    public BaseEntity(String id, LocalDate timeCreated) {
        this.id = id;
        this.timeCreated = timeCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDate timeCreated) {
        this.timeCreated = timeCreated;
    }
}
