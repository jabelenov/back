package com.example.bikeeccomerce.mapper;

import com.example.bikeeccomerce.model.BikeRecord;
import com.example.bikeeccomerce.request.CreateBikeRequest;

public class BikerMapper {

    public static BikeRecord mapToCreate(CreateBikeRequest request){
        BikeRecord bikeRecord = new BikeRecord();
        bikeRecord.setName(request.getName());
        bikeRecord.setCategory(request.getCategory());
        bikeRecord.setYearFabric(request.getYearFabric());
        bikeRecord.setModel(request.getModel());
        bikeRecord.setDescription(request.getDescription());
        bikeRecord.setPrice(request.getPrice());
        return bikeRecord;
    }

    public static BikeRecord mapToUpdate(BikeRecord bikeRecord, CreateBikeRequest request){
        bikeRecord.setName(request.getName());
        bikeRecord.setCategory(request.getCategory());
        bikeRecord.setYearFabric(request.getYearFabric());
        bikeRecord.setModel(request.getModel());
        bikeRecord.setDescription(request.getDescription());
        bikeRecord.setPrice(request.getPrice());
        return bikeRecord;
    }
}
