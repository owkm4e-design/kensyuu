package com.example.moattravel.event;

import org.springframework.context.ApplicationEvent;

import com.example.moattravel.entity.User;

import lombok.Getter;

//イベント発生を知らせる＋イベント情報の保持
@Getter
public class SignupEvent extends ApplicationEvent{

	private User user;//会員登録したユーザー情報の保持
	private String requestUrl;//リクエストを受けたURLの保持
	
	public SignupEvent(Object source,User user,String requestUrl) {
		super(source);
		
		this.user=user;
		this.requestUrl=requestUrl;
	}
}
