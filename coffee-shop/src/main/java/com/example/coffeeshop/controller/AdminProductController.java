package com.example.coffeeshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.form.ProductRegisterForm;
import com.example.coffeeshop.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/products")
@AllArgsConstructor
//管理者用の商品窓口
public class AdminProductController {

	private final ProductRepository productRepository;

	@GetMapping
	//商品一覧
	public String index(Model model) {
		List<Product> products = productRepository.findAll();

		model.addAttribute("products", products);

		return "admin/products/index";
	}

	@GetMapping("/{id}")
	//商品詳細
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		Product product = productRepository.getReferenceById(id);

		model.addAttribute("product", product);

		return "admin/products/show";

	}

	@GetMapping("/register")
	//商品登録
	public String register(Model model) {
		model.addAttribute("productRegisterForm", new ProductRegisterForm());

		return "admin/products/register";
	}
}
