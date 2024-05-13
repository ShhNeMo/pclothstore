package com.pclothstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_preferences_seq")
    @SequenceGenerator(name = "customer_preferences_seq", sequenceName = "customer_preferences_id_seq", allocationSize = 1)
    private Long id;

    private Long customerId;

    private String fabricType;
    private String color;
    private String size;
}
