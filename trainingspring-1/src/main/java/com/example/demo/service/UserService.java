package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

/*
 * ユーザ情報　Service
 */
@Service
public class UserService {
	/*
	 * ユーザ情報　Repositry
	 */
	@Autowired
	private UserRepository userRepository;

	/*
	 * ユーザ情報　全検索
	 * @return 検索結果
	 */
	public List<User> searchAll() {
		return userRepository.findAll();
	}

}
