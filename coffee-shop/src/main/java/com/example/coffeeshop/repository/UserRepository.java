package com.example.coffeeshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//メールアドレス（ユーザーID）でユーザ-を検索する
	public User findByEmail(String email);

	//名前orフリガナで検索する
	public Page<User> findByNameLikeOrFuriganaLike(String nameKeyword, String furiganaKeyword, Pageable pageable);
}
