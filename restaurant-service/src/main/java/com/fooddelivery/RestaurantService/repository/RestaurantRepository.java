package com.fooddelivery.RestaurantService.repository;

import com.fooddelivery.RestaurantService.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
