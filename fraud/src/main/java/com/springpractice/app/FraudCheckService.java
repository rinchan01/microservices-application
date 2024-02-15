package com.springpractice.app;

import com.springpractice.app.entity.FraudCheckHistory;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public record FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) { 

    @SuppressWarnings("null")
    public boolean isFraud(Integer customerId) {
        // some fraud check logic
        fraudCheckHistoryRepository.save(
            FraudCheckHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .isFrauder(false)
                .build()
        );
        return false;
    }
}
