package com.example.bikeeccomerce.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "BIKE")
public class BikeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String category;
    private String model;
    private String yearFabric;
    private boolean status;
    private String description;
    private double price;
    private boolean car;

    @ManyToOne
    @JoinColumn(name = "buy_bike_by_client_id")
    private BuyBikeByClientRecord buyBikeByClientRecord;

}
