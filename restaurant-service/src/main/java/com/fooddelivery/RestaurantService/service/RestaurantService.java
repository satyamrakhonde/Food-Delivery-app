package com.fooddelivery.RestaurantService.service;

import com.fooddelivery.RestaurantService.dto.RestaurantDTO;
import com.fooddelivery.RestaurantService.entity.Restaurant;
import com.fooddelivery.RestaurantService.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream().map(restaurant -> modelMapper.map(restaurant, RestaurantDTO.class)).toList();

    }

    public RestaurantDTO updateRestaurant(Long id, RestaurantDTO restaurantDTO) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " +id));

//        restaurant.setId(restaurantDTO.getId());
        restaurant.setName(restaurantDTO.getName());
        restaurant.setLocation(restaurantDTO.getLocation());

        restaurantRepository.save(restaurant);
        return modelMapper.map(restaurant, RestaurantDTO.class);

    }

    public RestaurantDTO deleteRestaurant(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " +id));

        restaurantRepository.delete(restaurant);
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }
}
