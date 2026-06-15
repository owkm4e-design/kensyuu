package com.example.coffeeshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.coffeeshop.entity.Order;
import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;

	public List<Order> getOrderList(User user) {
		return orderRepository.findByUserOrderByCreatedAtDesc(user);
	}
}
