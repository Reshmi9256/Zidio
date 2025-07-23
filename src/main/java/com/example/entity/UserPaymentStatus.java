package com.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.example.Enum.PaymentStatus;

@Entity
@Table(name = "user_payment_status")
public class UserPaymentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDate lastPaidDate;

    private String remarks;

    // Constructors
    public UserPaymentStatus() {}

    public UserPaymentStatus(User user, PaymentStatus status, LocalDate lastPaidDate, String remarks) {
        this.user = user;
        this.status = status;
        this.lastPaidDate = lastPaidDate;
        this.remarks = remarks;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDate getLastPaidDate() {
        return lastPaidDate;
    }

    public void setLastPaidDate(LocalDate lastPaidDate) {
        this.lastPaidDate = lastPaidDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
