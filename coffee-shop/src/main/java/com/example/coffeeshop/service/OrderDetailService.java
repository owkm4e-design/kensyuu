package com.example.coffeeshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.coffeeshop.entity.Order;
import com.example.coffeeshop.entity.OrderDetail;
import com.example.coffeeshop.repository.OrderDetailRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderDetailService {

	private final OrderDetailRepository orderDetailRepository;

	public List<OrderDetail> findByOrder(Order order) {
		return orderDetailRepository.findByOrder(order);
	}
}
