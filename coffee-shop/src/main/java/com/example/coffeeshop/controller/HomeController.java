package com.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.coffeeshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final ProductService productService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", productService.findAll());
		return "index";
	}
}
