package com.example.repository;

import com.example.entity.Payment;
import com.example.Enum.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Get all payments for a specific user
    List<Payment> findByUserId(Long userId);

    // Get all payments by status (e.g., COMPLETED, FAILED)
    List<Payment> findByStatus(PaymentStatus status);

    // Get payments by transaction ID (if needed)
    Payment findByTransactionId(String transactionId);
}
