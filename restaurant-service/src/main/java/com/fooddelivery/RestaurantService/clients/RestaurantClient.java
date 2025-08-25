package com.fooddelivery.RestaurantService.clients;

import com.fooddelivery.RestaurantService.dto.RestaurantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "restaurant-service", url = "http://localhost:8082")
public interface RestaurantClient {

    @GetMapping("/restaurants/{id}")
    RestaurantDTO getRestaurantById(@PathVariable("id") Long id);
}
