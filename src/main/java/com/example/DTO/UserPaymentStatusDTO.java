package com.example.DTO;

import com.example.Enum.PaymentStatus;

import java.time.LocalDate;

public class UserPaymentStatusDTO {

    private Long userId;
    private String userName;
    private String userEmail;
    private PaymentStatus status;
    private LocalDate lastPaidDate;
    private String remarks;

    // Constructors
    public UserPaymentStatusDTO() {}

    public UserPaymentStatusDTO(Long userId, String userName, String userEmail, PaymentStatus status,
                                LocalDate lastPaidDate, String remarks) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.status = status;
        this.lastPaidDate = lastPaidDate;
        this.remarks = remarks;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

