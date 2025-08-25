package com.fooddelivery.Order.Service.clients;

import com.fooddelivery.RestaurantService.dto.RestaurantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "restaurant-service", url = "http://localhost:8083")
public interface RestaurantClient {

    @GetMapping("/restaurants/{id}")
    RestaurantDTO getRestaurantsById(@PathVariable("id") Long id);
}
