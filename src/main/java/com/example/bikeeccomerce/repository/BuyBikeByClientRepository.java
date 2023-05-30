package com.example.bikeeccomerce.repository;

import com.example.bikeeccomerce.model.BuyBikeByClientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuyBikeByClientRepository extends JpaRepository<BuyBikeByClientRecord, Long> {

    List<BuyBikeByClientRecord> findAllByClientId(long clientId);
}
