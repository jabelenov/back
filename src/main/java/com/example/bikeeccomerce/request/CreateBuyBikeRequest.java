package com.example.bikeeccomerce.request;

import lombok.Data;

@Data
public class CreateBuyBikeRequest {
    private long clientId;
    private long bikeId;
    private double price;
}
