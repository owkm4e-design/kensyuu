package com.example.moattravel.event;

import org.springframework.context.ApplicationEvent;//イベントのソース（発生源）などを保持

import com.example.moattravel.entity.User;

import lombok.Getter;

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
