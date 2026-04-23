package com.example.demo.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service　具体的な処理を書く
 */
@Service
@Transactional(rollbackOn=Exception.class)
public class UserService {

	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	UserRepository userRepository;

	public List<User> searchAll() {
		// ユーザーTBLの内容を全検索
		return userRepository.findAll();
	}
}