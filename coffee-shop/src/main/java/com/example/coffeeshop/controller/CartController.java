package com.example.coffeeshop.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coffeeshop.entity.CartItem;
import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.service.ProductService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CartController {

	private final ProductService productService;

	@PostMapping("cart/add")
	public String addCart(@RequestParam Integer productId,
			@RequestParam Integer quantity,
			HttpSession session) {

		Product product = productService.findById(productId);

		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

		if (cart == null) {
			cart = new ArrayList<>();
		}

		cart.add(new CartItem(product, quantity));

		session.setAttribute("cart", cart);

		return "redirect:/cart";
	}

	@GetMapping("/cart")
	public String cart(Model model, HttpSession session) {
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

		if (cart == null) {
			cart = new ArrayList<>();
		}

		model.addAttribute("cart", cart);

		return "cart";
	}

}
