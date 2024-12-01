package model;

import java.time.LocalDateTime;

public class Note {
    private LocalDateTime dateTime;
    private String description;

    public Note(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }

    // Геттеры и сеттеры
    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}