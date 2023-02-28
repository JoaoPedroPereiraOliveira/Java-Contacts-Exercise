package contacts;

import java.time.LocalDateTime;

public class Contacts {
    private String name;
    private String number;
    private LocalDateTime timeCreated;
    private LocalDateTime timeEdited;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
        this.timeCreated = LocalDateTime.now();
        this.timeEdited = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeEdited() {
        this.timeEdited = LocalDateTime.now();
    }

    public LocalDateTime getTimeEdited() {
        return timeEdited;
    }
}