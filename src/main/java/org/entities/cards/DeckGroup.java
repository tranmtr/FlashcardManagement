package org.entities.cards;

import org.database.SingleDecksTable;
import org.entities.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DeckGroup extends BaseEntity implements DeckComponent {
    private String name;
    private String description;
    private String parentId;
    private String userId;
    private List<DeckComponent> components;
    private boolean isFavourite;

    public DeckGroup(String id, LocalDateTime timeCreated, String name, String description,
                     String parentId, String userId, List<DeckComponent> components, boolean isFavourite) {
        super(id, timeCreated);
        this.name = name;
        this.description = description;
        this.parentId = parentId;
        this.userId = userId;
        if (components == null) {
            this.components = new ArrayList<DeckComponent>();
        } else {
            this.components = components;
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

    public List<DeckComponent> getComponents() {
        return components;
    }

    public void setComponents(List<DeckComponent> components) {
        this.components = components;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
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
        System.out.println("Group: " + this.name);
    }

    public void addDeck(DeckComponent deckComponent) {
        this.components.add(deckComponent);
        deckComponent.setParentId(this.getId());
    }
}
