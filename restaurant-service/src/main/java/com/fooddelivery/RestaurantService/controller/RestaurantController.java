package com.fooddelivery.RestaurantService.controller;

import com.fooddelivery.RestaurantService.dto.RestaurantDTO;
import com.fooddelivery.RestaurantService.entity.Restaurant;
import com.fooddelivery.RestaurantService.repository.RestaurantRepository;
import com.fooddelivery.RestaurantService.service.RestaurantService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantRepository repository;

    private final RestaurantService restaurantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant create(@RequestBody Restaurant req) {
        return repository.save(req);
    }

    @GetMapping("{id}")
    public Restaurant get(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        List<RestaurantDTO> restaurantDTOS = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurantDTOS, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@PathVariable Long id,
                                                          @RequestBody RestaurantDTO restaurantDTO) {

        RestaurantDTO restaurantDto = restaurantService.updateRestaurant(id, restaurantDTO);
        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestaurantDTO> deleteRestaurant(@PathVariable Long id) {
        RestaurantDTO restaurantDto = restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }
}
