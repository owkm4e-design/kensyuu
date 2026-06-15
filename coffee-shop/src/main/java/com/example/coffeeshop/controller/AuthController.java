package com.example.coffeeshop.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.entity.VerificationToken;
import com.example.coffeeshop.event.SignupEventPublisher;
import com.example.coffeeshop.form.SignupForm;
import com.example.coffeeshop.service.UserService;
import com.example.coffeeshop.service.VerificationTokenService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AuthController {

	private final UserService userService;
	private final SignupEventPublisher signupEventPublisher;
	private final VerificationTokenService verificationTokenService;

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
			RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {

		//登録済アドレスだった時エラーを表示
		if (userService.isEmailRegistered(signupForm.getEmail())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "すでに登録済のメールアドレスです");
			bindingResult.addError(fieldError);//エラー内容格納
		}

		//パスワード不一致
		if (!userService.isSamePassword(signupForm.getPassword(), signupForm.getPasswordConfirmation())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "password", "パスワードが不一致です。");
			bindingResult.addError(fieldError);//エラー内容格納
		}

		//エラーがあった場合登録ページに戻る
		if (bindingResult.hasErrors()) {//エラー内容格納されてたら
			return "auth/signup";
		}

		User createdUser = userService.create(signupForm);
		String requestUrl = new String(httpServletRequest.getRequestURL());
		signupEventPublisher.publishSignupEvent(createdUser, requestUrl);
		redirectAttributes.addFlashAttribute("successMessage",
				"ご入力いただいたメールアドレスに認証メールを送信しました。メールに記載されているリンクをクリックし、会員登録を完了してください。");

		return "redirect:/";//トップページにリダイレクト
	}

	@GetMapping("/signup/verify")
	public String verify(@RequestParam(name = "token") String token, Model model) {
		VerificationToken verificationToken = verificationTokenService.getVerificationToken(token);

		if (verificationToken != null) {
			User user = verificationToken.getUser();
			userService.enableUser(user);
			String successMessage = "会員登録完了。";
			model.addAttribute("successMessage", successMessage);
		} else {
			String errorMessage = "トークンが無効です。";
			model.addAttribute("errorMessage", errorMessage);
		}

		return "auth/verify";
	}

}
