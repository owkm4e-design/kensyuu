package com.example.moattravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/") //リンク先
	public String index() {
		return "index";//呼び出すビューの名前
	}
}
