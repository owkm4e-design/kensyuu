package com.example.moattravel.event;

import org.springframework.context.ApplicationEvent;

import com.example.moattravel.entity.User;

import lombok.Getter;

//②イベントに関する情報を保持するクラス⇒Listenerクラスに知らせる
@Getter
public class SignupEvent extends ApplicationEvent {
	//イベントが持ち運ぶデータ
	private User user;//誰が登録したのか
	private String requestUrl;//メール認証のリンクを作るためのURL

	public SignupEvent(Object source, User user, String requestUrl) {
		//データを詰め込む
		super(source);

		this.user = user;
		this.requestUrl = requestUrl;
	}
	

}
