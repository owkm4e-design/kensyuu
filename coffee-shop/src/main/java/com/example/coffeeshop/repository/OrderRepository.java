
package com.example.coffeeshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.Order;
import com.example.coffeeshop.entity.User;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByUserOrderByCreatedAtDesc(User user);
}