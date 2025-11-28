package com.example.taskmaster.model;

public class Task {
    private String title;
    private String category;
    private int priority; // 1 = baja, 2 = media, 3 = alta
    private float rating; // importancia
    private boolean completed;

    public Task(String title, String category, int priority, float rating, boolean completed) {
        this.title = title;
        this.category = category;
        this.priority = priority;
        this.rating = rating;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getPriority() {
        return priority;
    }

    public float getRating() {
        return rating;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
