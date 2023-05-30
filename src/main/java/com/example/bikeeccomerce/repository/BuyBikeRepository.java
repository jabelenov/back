package com.example.bikeeccomerce.repository;

import com.example.bikeeccomerce.model.BuyBikeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyBikeRepository extends JpaRepository<BuyBikeRecord, Long> {
}
