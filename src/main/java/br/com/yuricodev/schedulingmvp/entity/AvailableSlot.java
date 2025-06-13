package br.com.yuricodev.schedulingmvp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AvailableSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private boolean isTaken;

    public AvailableSlot() {
    }

    public AvailableSlot(Long id, LocalDateTime dateTime, boolean isTaken) {
        this.id = id;
        this.dateTime = dateTime;
        this.isTaken = isTaken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        this.isTaken = taken;
    }
}
