package com.usersnotifications.model;

import java.time.LocalDate;

public class Notification {
    private int id;
    private String fromUsername;
    private String toUsername;
    private String description;
    private int fromUserId;
    private int toUserId;
    private LocalDate sentAt;
    private LocalDate readAt;
    private LocalDate createdAt;

    public Notification(int id, String fromUsername, LocalDate sentAt) {
        this.id = id;
        this.sentAt = sentAt;
        this.fromUsername = fromUsername;
    }

    public Notification(int fromUserId, int toUserId, String description, LocalDate sentAt) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.description = description;
        this.sentAt = sentAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public LocalDate getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDate sentAt) {
        this.sentAt = sentAt;
    }

    public LocalDate getReadAt() {
        return readAt;
    }

    public void setReadAt(LocalDate readAt) {
        this.readAt = readAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
