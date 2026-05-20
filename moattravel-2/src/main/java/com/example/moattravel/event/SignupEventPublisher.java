package com.example.moattravel.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.example.moattravel.entity.User;

//①イベントを発行するクラス
@Component
public class SignupEventPublisher {
	private final ApplicationEventPublisher applicationEventPublisher;

	//イベントを発行する専用マシンの準備
	public SignupEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	//イベントを発行するメソッド
	public void publishSignupEvent(User user, String requestUrl) {
		applicationEventPublisher.publishEvent(new SignupEvent(this, user, requestUrl));
	}

}
