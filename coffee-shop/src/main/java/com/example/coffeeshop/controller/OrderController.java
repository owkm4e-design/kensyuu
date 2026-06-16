package com.example.coffeeshop.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coffeeshop.entity.Order;
import com.example.coffeeshop.entity.OrderDetail;
import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.security.UserDetailsImpl;
import com.example.coffeeshop.service.OrderDetailService;
import com.example.coffeeshop.service.OrderService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

	private final OrderService orderService;
	private final OrderDetailService orderDetailService;

	@GetMapping
	//一覧画面の表示
	public String index(
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			Model model) {
		User user = userDetailsImpl.getUser();

		List<Order> orders = orderService.getOrderList(user);

		model.addAttribute("orders", orders);

		return "order/index";

	}

	@GetMapping("/{id}")
	//詳細画面の表示
	public String show(
			@PathVariable Integer id,
			Model model) {

		Order order = orderService.findById(id);

		List<OrderDetail> orderDetails = orderDetailService.findByOrder(order);

		model.addAttribute("orderDetails", orderDetails);
		model.addAttribute("order", order);

		return "order/show";
	}
}
