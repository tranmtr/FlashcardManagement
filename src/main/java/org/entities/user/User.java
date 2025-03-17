package org.entities.user;

import org.entities.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User extends BaseEntity {
    private String username;
    private String password;
    private String name;
    private String email;

    public User(String id, LocalDateTime timeCreated, String username, String password, String name, String email) {
        super(id, timeCreated);
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
