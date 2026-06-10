package com.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coffeeshop.service.CartService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {

	private final CartService cartService;

	@PostMapping("/add")
	public String addCart(
			//@AuthenticationPrincipal LoginUser loginUser,
			@RequestParam Integer productId,
			@RequestParam Integer gram,
			@RequestParam Integer quantity) {

		cartService.addCartItem(productId, gram, quantity);
		//cartService.addCartItem(loginUser.getUser(), productId, gram, quantity);

		return "redirect:/cart";
	}

	@GetMapping
	public String cart(Model model) {

		model.addAttribute("cartItems", cartService.getCartItems());

		model.addAttribute("totalPrice", cartService.getTotalPrice());

		return "cart";
	}

	@GetMapping("/delete")
	public String deleteCartItem(@RequestParam Integer cartItemId) {
		cartService.deleteCartItem(cartItemId);

		return "redirect:/cart";
	}

}
