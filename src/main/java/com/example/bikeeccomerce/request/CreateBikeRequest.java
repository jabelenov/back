package com.example.bikeeccomerce.request;

import lombok.Data;

@Data
public class CreateBikeRequest {
    private String name;
    private String category;
    private String yearFabric;
    private String model;
    private String description;
    private double price;

}
