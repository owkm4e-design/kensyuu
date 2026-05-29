package com.example.moattravel.event;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.moattravel.entity.User;
import com.example.moattravel.service.VerificationTokenService;

@Component//DIコンテナに登録される⇒自動で検出してイベント発生時に実行してくれる
public class SignupEventListener {

	private final VerificationTokenService verificationTokenService;
	private final JavaMailSender javaMailSender;

	public SignupEventListener(VerificationTokenService verificationTokenService,
			JavaMailSender mailSender) {
		this.verificationTokenService = verificationTokenService;
		this.javaMailSender = mailSender;
	}

	//登録ボタンがトリガーとなりメールが送られる
	@EventListener//イベント発生時に実行
	public void onSignupEvent(SignupEvent signupEvent) {
		User user = signupEvent.getUser();
		String token = UUID.randomUUID().toString();
		verificationTokenService.create(user, token);

		String recipientAddress = user.getEmail();
		String subject = "メール認証";
		String confirmationUrl = signupEvent.getRequestUrl() +
				"/verify?token=" + token;
		String message = "以下のリンクをクリックして会員登録を完了して下さい。";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(recipientAddress);
		mailMessage.setSubject(subject);
		mailMessage.setText(message + "\n" + confirmationUrl);
		javaMailSender.send(mailMessage);
	}
}
