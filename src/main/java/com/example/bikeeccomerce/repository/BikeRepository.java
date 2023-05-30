package com.example.bikeeccomerce.repository;

import com.example.bikeeccomerce.model.BikeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRepository extends JpaRepository<com.example.bikeeccomerce.model.BikeRecord, Long> {

    List<BikeRecord> findAllByCarIsTrue();
}
