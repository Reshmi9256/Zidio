package com.example.DTO;

import com.example.Enum.PaymentStatus;
import com.example.Enum.PaymentType;

import java.time.LocalDateTime;

public class PaymentDTO {

    private Long id;
    private Double amount;
    private PaymentStatus status;
    private LocalDateTime paymentDate;
    private String transactionId;
    private PaymentType paymentType;
    private Long userId;
    private String userEmail;

    // Constructors
    public PaymentDTO() {}

    public PaymentDTO(Long id, Double amount, PaymentStatus status, LocalDateTime paymentDate,
                      String transactionId, PaymentType paymentType, Long userId, String userEmail) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.paymentDate = paymentDate;
        this.transactionId = transactionId;
        this.paymentType = paymentType;
        this.userId = userId;
        this.userEmail = userEmail;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

