package com.fooddelivery.Order.Service.dto;

import com.fooddelivery.RestaurantService.entity.Restaurant;
import com.fooddelivery.UserService.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private String orderId;
    private Users user;
    private Restaurant restaurant;
    private String itemName;
    private int quantity;
    private String status;
}
