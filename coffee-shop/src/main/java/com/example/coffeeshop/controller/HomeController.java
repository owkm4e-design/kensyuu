package com.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.coffeeshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {//@RequestMappingをつけないことで直下のページを自由に担当する

	private final ProductService productService;

	@GetMapping("/") //トップページ
	public String index(Model model) {
		model.addAttribute("products", productService.findAll());//商品情報を全件取得
		return "index";//index(HTML)
	}

}
