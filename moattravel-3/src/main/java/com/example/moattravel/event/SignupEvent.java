package com.example.moattravel.event;

import org.springframework.context.ApplicationEvent;

import com.example.moattravel.entity.User;

import lombok.Getter;

//イベントが発生したことを知らせるクラス
@Getter
public class SignupEvent extends ApplicationEvent {

	private User user;
	private String requestUrl;

	public SignupEvent(Object source, User user, String requestUrl) {
		super(source);

		this.user = user;
		this.requestUrl = requestUrl;
	}
}
