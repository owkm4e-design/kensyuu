package com.example.moattravel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);

	//SQLのAND検索やOR検索を行うことができる
	public Page<User> findByNameLikeOrFuriganaLike(String namekeyword, String furiganakeyword, Pageable pageable);
}
