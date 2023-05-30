package com.example.bikeeccomerce.rest;

import com.example.bikeeccomerce.model.BikeRecord;
import com.example.bikeeccomerce.request.CreateBikeRequest;
import com.example.bikeeccomerce.service.BikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }
    @GetMapping
    public List<BikeRecord> findAll(){
        return bikeService.findAll();
    }
    @GetMapping("/{id}")
    public BikeRecord findById(@PathVariable long id){
        return bikeService.findById(id);
    }

    @PostMapping
    public BikeRecord save(@RequestBody CreateBikeRequest request){
        return bikeService.save(request);
    }

    @PutMapping("/update/{id}")
    public BikeRecord update(@PathVariable long id,@RequestBody CreateBikeRequest request){
        return bikeService.update(id, request);
    }

    @PutMapping("/cart/{id}")
    public BikeRecord addCar(@PathVariable long id){
        return bikeService.addCar(id);
    }

    @PutMapping("/cart/delete/{id}")
    public BikeRecord deleteCar(@PathVariable long id){
        return bikeService.deleteCar(id);
    }

    @GetMapping("/cart/bike")
    public List<BikeRecord> findAllByCar(){
        return bikeService.findAllByCar();
    }


}
