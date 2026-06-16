package com.example.coffeeshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coffeeshop.entity.Order;
import com.example.coffeeshop.repository.OrderRepository;
import com.example.coffeeshop.service.OrderDetailService;
import com.example.coffeeshop.service.OrderService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/orders")
public class AdminOrderController {

	private final OrderRepository orderRepository;
	private final OrderService orderService;
	private final OrderDetailService orderDetailService;

	//（管理者用）商品一覧
	@GetMapping
	public String index(Model model) {

		List<Order> orders = orderRepository.findAll();
		model.addAttribute("orders", orders);
		return "admin/orders/index";

	}
	
	//（管理者用）詳細
	@GetMapping("/{id}")
	public String show(@PathVariable Integer id,Model model) {
		
		
	}
}
