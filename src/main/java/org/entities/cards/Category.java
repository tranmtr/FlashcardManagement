package org.entities.cards;

import org.entities.BaseEntity;

import java.time.LocalDate;

public class Category extends BaseEntity {
    private String name;
    private String description;

    public Category(String id, LocalDate timeCreated, String name, String description) {
        super(id, timeCreated);
        this.name = name;
        this.description = description;
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
}
