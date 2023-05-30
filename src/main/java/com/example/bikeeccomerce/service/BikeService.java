package com.example.bikeeccomerce.service;

import com.example.bikeeccomerce.mapper.BikerMapper;
import com.example.bikeeccomerce.model.BikeRecord;
import com.example.bikeeccomerce.repository.BikeRepository;
import com.example.bikeeccomerce.request.CreateBikeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }


    public BikeRecord findById(long id){
        return bikeRepository.findById(id).orElseThrow(() -> new RuntimeException("Bike not found"));
    }

    public List<BikeRecord> findAll(){
        return bikeRepository.findAll();
    }

    public BikeRecord save(CreateBikeRequest request){
        return bikeRepository.save(BikerMapper.mapToCreate(request));
    }

    public BikeRecord update(long id, CreateBikeRequest request){
        BikeRecord bikeRecord = bikeRepository.findById(id).orElseThrow(() -> new RuntimeException("Bike not found"));
        return bikeRepository.save(BikerMapper.mapToUpdate(bikeRecord, request));
    }

    public BikeRecord addCar(long id){
        BikeRecord bikeRecord = bikeRepository.findById(id).orElseThrow(() -> new RuntimeException("Bike not found"));
        bikeRecord.setCar(true);
        return bikeRepository.save(bikeRecord);
    }

    public BikeRecord deleteCar(long id){
        BikeRecord bikeRecord = bikeRepository.findById(id).orElseThrow(() -> new RuntimeException("Bike not found"));
        bikeRecord.setCar(false);
        return bikeRepository.save(bikeRecord);
    }

    public List<BikeRecord> findAllByCar(){
        return bikeRepository.findAllByCarIsTrue();
    }

}
