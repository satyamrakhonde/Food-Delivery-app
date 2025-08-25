package com.fooddelivery.UserService.clients;

import com.fooddelivery.UserService.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service",url = "http://localhost:8081")
public interface UserClient {

    @GetMapping
    UserDTO getUserById(@PathVariable("id") Long id);
}
