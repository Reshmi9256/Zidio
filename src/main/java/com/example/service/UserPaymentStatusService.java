package com.example.service;

import com.example.DTO.UserPaymentStatusDTO;
import com.example.Enum.PaymentStatus;
import com.example.entity.User;
import com.example.entity.UserPaymentStatus;
import com.example.repository.UserPaymentStatusRepository;
import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserPaymentStatusService {

    @Autowired
    private UserPaymentStatusRepository userPaymentStatusRepository;

    @Autowired
    private UserRepository userRepository;

    // Get user payment status by user ID
    public UserPaymentStatusDTO getStatusByUserId(Long userId) {
        Optional<UserPaymentStatus> optionalStatus = userPaymentStatusRepository.findByUserId(userId);

        if (optionalStatus.isPresent()) {
            UserPaymentStatus status = optionalStatus.get();
            return convertToDTO(status);
        } else {
            throw new RuntimeException("User payment status not found for user ID: " + userId);
        }
    }

    // Create or update user payment status
    public UserPaymentStatusDTO updateStatus(Long userId, PaymentStatus status, String remarks) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        UserPaymentStatus userPaymentStatus = userPaymentStatusRepository.findByUserId(userId)
                .orElse(new UserPaymentStatus());

        userPaymentStatus.setUser(user);
        userPaymentStatus.setStatus(status);
        userPaymentStatus.setLastPaidDate(LocalDate.now());
        userPaymentStatus.setRemarks(remarks);

        UserPaymentStatus saved = userPaymentStatusRepository.save(userPaymentStatus);

        return convertToDTO(saved);
    }

    // Convert to DTO
    private UserPaymentStatusDTO convertToDTO(UserPaymentStatus status) {
        return new UserPaymentStatusDTO(
                status.getUser().getId(),
                status.getUser().getName(),
                status.getUser().getEmail(),
                status.getStatus(),
                status.getLastPaidDate(),
                status.getRemarks()
        );
    }
}
