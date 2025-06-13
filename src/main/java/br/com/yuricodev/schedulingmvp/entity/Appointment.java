package br.com.yuricodev.schedulingmvp.entity;

import br.com.yuricodev.schedulingmvp.entity.Enums.TypeStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String clientName;

    @Enumerated(EnumType.STRING)
    private TypeStatus status;

    public Appointment() {
    }

    public Appointment(Long id, LocalDateTime dateTime, String clientName, TypeStatus status) {
        this.id = id;
        this.dateTime = dateTime;
        this.clientName = clientName;
        this.status = status;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public TypeStatus getStatus() {
        return status;
    }

    public void setStatus(TypeStatus status) {
        this.status = status;
    }
}
