package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class) //Exception系が１つでもあれば戻す
public class UserService {
	@Autowired //必要な部品（クラス）を自動で用意して注入してくれる
	private UserRepository userRepository;//UserRepository をこのクラスで使えるように自動で準備しているコード

	public List<User> searchAll() {//List<User>：User一覧、searchAll()：全件検索
		return userRepository.findAll();//User全員のデータをDBから取って返す
	}

	public void create(UserRequest userRequest) {//
		Date now = new Date();
		User user = new User();
		user.setName(userRequest.getName());
		user.setAddress(userRequest.getAddress());
		user.setPhone(userRequest.getPhone());
		user.setCreateDate(now);
		user.setUpdateDate(now);
		userRepository.save(user);
	}
	
}
