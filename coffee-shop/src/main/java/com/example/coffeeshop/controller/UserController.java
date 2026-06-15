package com.example.coffeeshop.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.form.UserEditForm;
import com.example.coffeeshop.repository.UserRepository;
import com.example.coffeeshop.security.UserDetailsImpl;
import com.example.coffeeshop.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private final UserRepository userRepository;
	private final UserService userService;

	@GetMapping
	//認証済ユーザーの情報取得
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		//service経由にする
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());

		model.addAttribute("user", user);

		return "user/index";
	}

	@GetMapping("/edit")
	public String edit(Model model, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		//userService経由に直す
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());

		UserEditForm userEditForm = new UserEditForm(user.getId(), user.getName(), user.getFurigana(),
				user.getPostalCode(), user.getAddress(), user.getPhoneNumber(), user.getEmail());

		model.addAttribute("userEditForm", userEditForm);
		
		return "user/edit";
	}
	
	@PostMapping("")
}
