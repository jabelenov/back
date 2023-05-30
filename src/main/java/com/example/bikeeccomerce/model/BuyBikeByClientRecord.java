package com.example.bikeeccomerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Data
@Table(name = "BUY_BIKE_BY_CLIENT")
public class BuyBikeByClientRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long clientId;

    @OneToMany(mappedBy = "buyBikeByClientRecord", cascade = CascadeType.ALL)
    private Collection<BikeRecord> bikeRecords;

    public Collection<BikeRecord> getBikeRecords() {
        if (bikeRecords == null) {
            bikeRecords = new ArrayList<>();
        }
        return bikeRecords;
    }

}
