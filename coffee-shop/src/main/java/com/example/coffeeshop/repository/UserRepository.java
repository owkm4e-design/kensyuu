package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//メールアドレス（ユーザーID）でユーザ-を検索する
	public User findByEmail(String email);
}
