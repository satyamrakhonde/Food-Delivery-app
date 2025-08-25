package com.fooddelivery.Order.Service.service;

import com.fooddelivery.Order.Service.clients.RestaurantClient;
import com.fooddelivery.Order.Service.clients.UserClient;
import com.fooddelivery.Order.Service.dto.OrderRequestDTO;
import com.fooddelivery.Order.Service.dto.OrderResponseDTO;
import com.fooddelivery.RestaurantService.dto.RestaurantDTO;
import com.fooddelivery.UserService.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private RestaurantClient restaurantClient;

    public OrderResponseDTO placeOrder(OrderRequestDTO request) {
        // fetch user + restaurant info
        UserDTO user = userClient.getUserById(request.getUserId());
        RestaurantDTO restaurant = restaurantClient.getRestaurantById(request.getRestaurantId());

        // create order response
        OrderResponseDTO response = new OrderResponseDTO();
        response.setOrderId(System.currentTimeMillis());
        response.setUser(user);
        response.setRestaurant(restaurant);
        response.setItemName(request.getItemName());
        response.setQuantity(request.getQuantity());
        response.setStatus("ORDER_PLACED");

        return response;
    }
}
