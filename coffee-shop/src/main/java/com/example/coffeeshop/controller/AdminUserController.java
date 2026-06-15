package com.example.coffeeshop.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.repository.UserRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/users")
public class AdminUserController {

	private final UserRepository userRepository;

	//ユーザー一覧（管理者）
	@GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {

		Page<User> userPage;

		//Service経由に変える？
		if (keyword != null && !keyword.isEmpty()) {
			userPage = userRepository.findByNameLikeOrFuriganaLike(keyword, keyword, pageable);
		} else {
			userPage = userRepository.findAll(pageable);
		}

		model.addAttribute("userPage", userPage);
		model.addAttribute("keyword", keyword);

		return "admin/users/index";
	}

	//ユーザー詳細
	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		//IDをもとに検索
		User user = userRepository.getReferenceById(id);

		//
		model.addAttribute("user", user);

		return "admin/users/show";
	}

}
