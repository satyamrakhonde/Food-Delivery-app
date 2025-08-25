package com.fooddelivery.Order.Service.repository;

import com.fooddelivery.Order.Service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {


}
