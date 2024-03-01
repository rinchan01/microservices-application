package com.springpractice.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fraud_check_history")
@Entity
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraud_check_history_id_sequence",
            sequenceName = "fraud_check_history_id_sequence"
    )
    @javax.persistence.GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "fraud_check_history_id_sequence"
    )
    private Integer id;
    private Integer customerId;
    private Boolean isFrauder;
    private LocalDateTime createdAt;
}
