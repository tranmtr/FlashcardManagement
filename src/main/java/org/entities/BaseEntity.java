package org.entities;

public class BaseEntity {
    private String id;
    private String timeCreated;

    public BaseEntity(String id, String timeCreated) {
        this.id = id;
        this.timeCreated = timeCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }
}
