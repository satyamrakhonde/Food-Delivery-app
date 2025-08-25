package com.fooddelivery.RestaurantService.controller;

import com.fooddelivery.RestaurantService.dto.RestaurantDTO;
import com.fooddelivery.RestaurantService.entity.Restaurant;
import com.fooddelivery.RestaurantService.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantRepository repository;

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
}
