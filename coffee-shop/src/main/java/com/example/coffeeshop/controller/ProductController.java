package com.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coffeeshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	@GetMapping("/{id}") //商品詳細ページ
	public String detail(@PathVariable(name = "id") Integer id, Model model) {
		//ProductServiceにIDから商品を探すように依頼
		model.addAttribute("product", productService.findById(id));

		return "product/detail";//product/detail(HTML)
	}
}
