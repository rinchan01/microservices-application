package com.springpractice.app;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springpractice.app.entity.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer>{
    
}
