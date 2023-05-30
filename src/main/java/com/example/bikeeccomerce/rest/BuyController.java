package com.example.bikeeccomerce.rest;

import com.example.bikeeccomerce.model.BuyBikeByClientRecord;
import com.example.bikeeccomerce.model.BuyBikeRecord;
import com.example.bikeeccomerce.request.CreateBuyBikeRequest;
import com.example.bikeeccomerce.request.ProductIdReques;
import com.example.bikeeccomerce.service.BuyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buy")
public class BuyController {

    private final BuyService buyService;

    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

    @GetMapping("/{id}")
    public BuyBikeRecord findById(@PathVariable long id){
        return buyService.findById(id);
    }

    @GetMapping
    public List<BuyBikeRecord> findAll(){
        return buyService.findAllBikeRecord();
    }

    @PostMapping(consumes = "application/json" , produces = "application/json" )
    public void createBuy(@RequestBody CreateBuyBikeRequest request){
        buyService.createPurchase(request);
    }

    @PostMapping("/cart/{clientId}")
    public void buyCart(@PathVariable long clientId, @RequestBody List<ProductIdReques> request){
        buyService.buyCart(clientId, request);
    }

    @GetMapping("/user/{id}")
    public List<BuyBikeByClientRecord> findByUserId(@PathVariable long id){
        return buyService.findByClient(id);
    }
}
