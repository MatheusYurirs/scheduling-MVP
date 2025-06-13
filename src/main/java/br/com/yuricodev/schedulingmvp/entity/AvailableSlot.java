package br.com.yuricodev.schedulingmvp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class AvailableSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private boolean is_taken;

    public AvailableSlot() {
    }

    public AvailableSlot(Long id, LocalDateTime dateTime, boolean is_taken) {
        this.id = id;
        this.dateTime = dateTime;
        this.is_taken = is_taken;
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

    public boolean isIs_taken() {
        return is_taken;
    }

    public void setIs_taken(boolean is_taken) {
        this.is_taken = is_taken;
    }
}
