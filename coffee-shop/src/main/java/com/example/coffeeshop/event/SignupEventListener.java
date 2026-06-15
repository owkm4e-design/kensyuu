package com.example.coffeeshop.event;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.service.VerificationTokenService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SignupEventListener {

	private final VerificationTokenService verificationTokenService;
	private final JavaMailSender javaMailSender;

	@EventListener //イベント発生時に実行
	private void onSignupEvent(SignupEvent signupEvent) {

		User user = signupEvent.getUser();
		String token = UUID.randomUUID().toString();//トークンをUUIDで作成
		verificationTokenService.create(user, token);

		String recipientAddress = user.getEmail();
		String subject = "メール認証";
		String confirmationUrl = signupEvent.getRequestUrl() + "/verify?token=" + token;
		String message = "以下のリンクをクリックして会員登録を完了してください。";

		SimpleMailMessage mailMessage = new SimpleMailMessage();//メール作成
		mailMessage.setTo(recipientAddress);//宛先
		mailMessage.setSubject(subject);//件名
		mailMessage.setText(message + "\n" + confirmationUrl);//本文
		javaMailSender.send(mailMessage);//送信

	}
}
