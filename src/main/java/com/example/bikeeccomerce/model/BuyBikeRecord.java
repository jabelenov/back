package com.example.bikeeccomerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BUY_BIKE")
public class BuyBikeRecord {

    @Id
    @GeneratedValue
    private long id;
    private long clientId;
    private long bikeId;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private double price;

}
