package com.example.coffeeshop.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.example.coffeeshop.entity.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SignupEventPublisher {

	private final ApplicationEventPublisher applicationEventPublisher;

	public void publishSignupEvent(User user, String requestUrl) {

		//publishEvent()メソッドでイベントを発行
		applicationEventPublisher.publishEvent(new SignupEvent(this, user, requestUrl));
	}
}
