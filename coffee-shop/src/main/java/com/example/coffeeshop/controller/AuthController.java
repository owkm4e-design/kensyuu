package com.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.coffeeshop.form.SignupForm;
import com.example.coffeeshop.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AuthController {

	private final UserService userService;

	//ログイン画面
	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	//会員登録画面
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new SignupForm());

		return "auth/signup";
	}

	//会員登録
	@PostMapping("/signup")
	public String signup(@Validated SignupForm signupForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		//登録済アドレスだった時エラーを表示
		if (userService.isEmailRegisterd(signupForm.getEmail())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "すでに登録済のメールアドレスです");
			bindingResult.addError(fieldError);
		}

		//パスワード不一致
		if (!userService.isSamePassword(signupForm.getPassword(), signupForm.getPasswordConfirmation())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "password", "パスワードが不一致です。");
			bindingResult.addError(fieldError);
		}

		//エラーがあった場合登録ページに戻る
		if (bindingResult.hasErrors()) {
			return "auth/signup";
		}

		userService.create(signupForm);
		redirectAttributes.addFlashAttribute("successMessage", "会員登録完了");

		return "redirect:/";
	}

}
