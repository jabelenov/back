package com.example.bikeeccomerce.service;

import com.example.bikeeccomerce.model.BikeRecord;
import com.example.bikeeccomerce.model.BuyBikeByClientRecord;
import com.example.bikeeccomerce.model.BuyBikeRecord;
import com.example.bikeeccomerce.repository.BikeRepository;
import com.example.bikeeccomerce.repository.BuyBikeByClientRepository;
import com.example.bikeeccomerce.repository.BuyBikeRepository;
import com.example.bikeeccomerce.request.CreateBuyBikeRequest;
import com.example.bikeeccomerce.request.ProductIdReques;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyService {

    private final BuyBikeRepository buyBikeRepository;
    private final BuyBikeByClientRepository buyBikeByClientRepository;
    private final BikeRepository bikeRepository;
    private final BikeService bikeService;

    public BuyService(BuyBikeRepository buyBikeRepository, BuyBikeByClientRepository buyBikeByClientRepository, BikeRepository bikeRepository, BikeService bikeService) {
        this.buyBikeRepository = buyBikeRepository;
        this.buyBikeByClientRepository = buyBikeByClientRepository;
        this.bikeRepository = bikeRepository;
        this.bikeService = bikeService;
    }

    public List<BuyBikeRecord> findAllBikeRecord(){
         return buyBikeRepository.findAll();
    }

    public void createPurchase(CreateBuyBikeRequest request){
        BikeRecord bikeRecord = bikeService.findById(request.getBikeId());
        BuyBikeByClientRecord buyBikeByClientRecord = new BuyBikeByClientRecord();
        buyBikeByClientRecord.setClientId(request.getClientId());
        buyBikeByClientRecord.getBikeRecords().add(bikeRecord);
        buyBikeByClientRepository.save(buyBikeByClientRecord);
        BuyBikeRecord buyBikeRecord = BuyBikeRecord.builder()
                .bikeId(request.getBikeId())
                .clientId(request.getClientId())
                .price(request.getPrice())
                .createAt(LocalDateTime.now())
                .build();
        buyBikeRepository.save(buyBikeRecord);
    }

    public void buyCart(long clientId, List<ProductIdReques> reques){
        double price = 0;
        int quantity = 0;
        List<BikeRecord> productRecords = reques.stream().map(
                products -> {
                    BikeRecord product = bikeRepository.findById((long) products.getId()).orElseThrow(() -> new RuntimeException("Product not found"));
                    return product;
                }).collect(Collectors.toList());
        for (BikeRecord productRecord : productRecords) {
            price += productRecord.getPrice();
            quantity++;
            productRecord.setCar(false);
        }
        BuyBikeByClientRecord buyBikeByClientRecord = new BuyBikeByClientRecord();
        buyBikeByClientRecord.setClientId(clientId);
        buyBikeByClientRecord.getBikeRecords().addAll(productRecords);
        buyBikeByClientRepository.save(buyBikeByClientRecord);
        BuyBikeRecord buyBikeRecord = BuyBikeRecord.builder()
                .bikeId(productRecords.get(0).getId())
                .clientId(clientId)
                .price(price)
                .createAt(LocalDateTime.now())
                .build();
        buyBikeRepository.save(buyBikeRecord);
    }

    public List<BuyBikeByClientRecord> findByClient(long clientId){
        return buyBikeByClientRepository.findAllByClientId(clientId);
    }

    public BuyBikeRecord findById(long id){
        return buyBikeRepository.findById(id).orElseThrow(() -> new RuntimeException("Purchase not found"));
    }

    public void delete(long id){
        buyBikeRepository.deleteById(id);
    }


}
