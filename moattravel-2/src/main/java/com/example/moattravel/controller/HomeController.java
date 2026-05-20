package com.example.moattravel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.moattravel.entity.House;
import com.example.moattravel.repository.HouseRepository;

@Controller
public class HomeController {
	private final HouseRepository houseRepository;

	public HomeController(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

	@GetMapping("/") //リンク先
	public String index(Model model) {
		List<House> newHouses = houseRepository.findTopByOrderByCreatedAtDesc();
		model.addAttribute("newHouses", newHouses);

		return "index";//呼び出すビューの名前
	}
}
