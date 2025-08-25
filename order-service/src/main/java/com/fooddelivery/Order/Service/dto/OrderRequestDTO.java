package com.fooddelivery.Order.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private Long userId;
    private Long restaurantId;
    private String itemName;
    private int quantity;
}
