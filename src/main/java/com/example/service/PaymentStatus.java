
package com.example.service;

import com.example.DTO.PaymentDTO;
import com.example.Enum.*;

import com.example.entity.Payment;
import com.example.entity.User;
import com.example.repository.PaymentRepository;
import com.example.repository.UserRepository;
import com.example.Enum.PaymentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentStatus {

    private static final com.example.Enum.PaymentStatus COMPLETED = null;

	@Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    // Save a new payment
    public PaymentDTO createPayment(Long userId, Double amount, PaymentType paymentType, String transactionId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        User user = userOptional.get();

        Payment payment = new Payment();
        payment.setUser(user);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus(PaymentStatus.COMPLETED);
        payment.setPaymentMethod(paymentType.name());
        payment.setTransactionId(transactionId);

        Payment savedPayment = paymentRepository.save(payment);
        return convertToDTO(savedPayment);
    }

    // Get all payments
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get payments by user
    public List<PaymentDTO> getPaymentsByUserId(Long userId) {
        return paymentRepository.findAll()
                .stream()
                .filter(p -> p.getUser().getId().equals(userId))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Convert Payment to DTO
    private PaymentDTO convertToDTO(Payment payment) {
        return new PaymentDTO(
                payment.getId(),
                payment.getAmount(),
                payment.getStatus(),
                payment.getPaymentDate(),
                payment.getTransactionId(),
                PaymentType.valueOf(payment.getPaymentMethod()),
                payment.getUser().getId(),
                payment.getUser().getEmail()
        );
    }
}
