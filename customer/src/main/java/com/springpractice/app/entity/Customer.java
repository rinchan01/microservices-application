package com.springpractice.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "customers")
@Entity
public class Customer {

    @Id
    // connect to the sequence that we created in the database
    @SequenceGenerator(
            name = "customer_id_sequence", // name of the sequence
            sequenceName = "customer_id_sequence" // actual sequence name in the database
    )
    // config the sequence to be auto incremented
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}