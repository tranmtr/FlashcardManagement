package org.entities;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    private String id;
    private LocalDateTime timeCreated;

    public BaseEntity(String id, LocalDateTime timeCreated) {
        this.id = id;
        this.timeCreated = timeCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }
}
