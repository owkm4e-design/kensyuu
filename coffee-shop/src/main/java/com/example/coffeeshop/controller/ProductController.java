package com.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.repository.ProductRepository;
import com.example.coffeeshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	private final ProductRepository productRepository;

	@GetMapping("/{id}")
	public String detail(@PathVariable(name = "id") Integer id, Model model) {
		Product product = productRepository.getReferenceById(id);

		model.addAttribute("product", product);
		//model.addAttribute(, )

		return "product/detail";
	}
}
