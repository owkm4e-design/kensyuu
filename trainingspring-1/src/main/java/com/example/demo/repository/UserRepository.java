package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

/*
 * ユーザ情報 Repository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//独自に追加したい場合はここに追加を書く
}
