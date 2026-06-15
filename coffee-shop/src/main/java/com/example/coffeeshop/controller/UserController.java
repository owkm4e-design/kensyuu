package com.example.coffeeshop.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		User user = userService.findById(userDetailsImpl.getUser().getId());

		model.addAttribute("user", user);

		return "user/index";
	}

	@GetMapping("/edit")
	public String edit(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {

		UserEditForm userEditForm = userService.createUserEditForm(userDetailsImpl.getUser().getId());

		model.addAttribute("userEditForm", userEditForm);

		return "user/edit";
	}

	@PostMapping("/edit")
	public String update(@ModelAttribute @Validated UserEditForm userEditForm,
			RedirectAttributes redirectAttributes,
			BindingResult bindingResult) {

		//変更済みかつ登録済みであればエラー
		if (userService.isEmailChanged(userEditForm) && userService.isEmailRegistered(userEditForm.getEmail())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "すでに登録済のメールアドレスです。");
			bindingResult.addError(fieldError);
		}

		//エラー内容が格納されていたら
		if (bindingResult.hasErrors()) {
			return "user/edit";
		}

		userService.update(userEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "会員情報を更新しました。");
		return "redirect:/user";
	}
}
