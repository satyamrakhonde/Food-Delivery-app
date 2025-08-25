package com.fooddelivery.UserService.repository;

import com.fooddelivery.UserService.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
