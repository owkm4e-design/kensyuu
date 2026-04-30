package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class) //処理の途中で失敗したら、データベースの変更を全部なかったことにする
public class UserService {
	/*
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserRepository userRepository;

	/*
	 * ユーザー情報　全検索
	 * @return 検索結果
	 */
	public List<User> searchAll() {//ユーザー一覧をデータベースから全部取得して返す
		return userRepository.findAll();//findAll()全件取得する
	}

	/**
	 * ユーザー情報 主キー検索
	 * @return 検索結果
	 */
	public User findById(Long id) {//IDで探す
		return userRepository.findById(id).get();//ID検索して、見つかったget()(User)を取り出して返す
	}

	/*
	 * ユーザー情報　新規登録
	 * @param user　ユーザー情報
	 */
	public void create(UserRequest userRequest) {
		Date now = new Date();//今この瞬間の日時を取得
		User user = new User();//DB保存用のUser箱を新しく作る
		user.setName(userRequest.getName());
		user.setAddress(userRequest.getAddress());
		user.setPhone(userRequest.getPhone());
		user.setCreateDate(now);
		user.setUpdateDate(now);
		userRepository.save(user);//UserデータをDBへ保存する
	}

	/*
	 * ユーザー情報　更新
	 * @param user ユーザー情報
	 */
	public void update(UserUpdateRequest userUpdateRequest) {
		User user = findById(userUpdateRequest.getId());
		user.setAddress(userUpdateRequest.getAddress());
		user.setName(userUpdateRequest.getName());
		user.setPhone(userUpdateRequest.getPhone());
		user.setUpdateDate(new Date());
		userRepository.save(user);
	}

	/*
	 * ユーザー情報　物理削除
	 * @param id ユーザーID
	 */
	public void delete(Long id) {
		User user = findById(id);
		userRepository.delete(user);
	}

}
