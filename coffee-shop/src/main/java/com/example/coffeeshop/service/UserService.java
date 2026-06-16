package com.example.coffeeshop.service;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.coffeeshop.entity.Role;
import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.form.SignupForm;
import com.example.coffeeshop.form.UserEditForm;
import com.example.coffeeshop.repository.RoleRepository;
import com.example.coffeeshop.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;

	//会員登録
	@Transactional
	public User create(SignupForm signupForm) {
		User user = new User();
		Role role = roleRepository.findByRoleName("ROLE_GENERAL");

		user.setName(signupForm.getName());
		user.setFurigana(signupForm.getFurigana());
		user.setPostalCode(signupForm.getPostalCode());
		user.setAddress(signupForm.getAddress());
		user.setPhoneNumber(signupForm.getPhoneNumber());
		user.setEmail(signupForm.getEmail());

		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));

		user.setEnabled(false);

		user.setRole(role);

		return userRepository.save(user);
	}

	//ユーザー情報の取得
	public UserEditForm createUserEditForm(Integer userId) {
		//Idから検索してユーザー情報を持ってくる
		User user = findById(userId);

		//それぞれの型に詰めてFormに返す
		return new UserEditForm(user.getId(), user.getName(), user.getFurigana(), user.getPostalCode(),
				user.getAddress(), user.getPhoneNumber(), user.getEmail());
	}

	//変更内容の保存
	@Transactional
	public void update(UserEditForm userEditForm) {
		//画面から送られてきたIDをもとにユーザーデータを１件取得
		User user = userRepository.findById(userEditForm.getId()).orElseThrow();

		//データを上書きする
		user.setName(userEditForm.getName());
		user.setFurigana(userEditForm.getFurigana());
		user.setPostalCode(userEditForm.getPostalCode());
		user.setAddress(userEditForm.getAddress());
		user.setPhoneNumber(userEditForm.getPhoneNumber());
		user.setEmail(userEditForm.getEmail());

		userRepository.save(user);

	}

	//メアド確認
	public boolean isEmailRegistered(String email) {
		User user = userRepository.findByEmail(email);

		return user != null;
	}

	//メアド変更されたかチェック
	public boolean isEmailChanged(UserEditForm userEditForm) {
		User currentUser = userRepository.getReferenceById(userEditForm.getId());
		return !userEditForm.getEmail().equals(currentUser.getEmail());
	}

	//ID検索
	public User findById(Integer id) {
		return userRepository.findById(id).orElseThrow();
	}

	//パスワード確認
	public boolean isSamePassword(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}

	//ユーザーを有効にする
	@Transactional
	public void enableUser(User user) {
		user.setEnabled(true);
		userRepository.save(user);
	}

	//利用停止
	@Transactional
	public void disableUser(Integer userId) {
		User user = findById(userId);
		user.setEnabled(false);
		//userRepository.save(user);
	}

	//利用再開
	/*@Transactional
	public void enableUser(Integer userId) {
		User user =findById(userId);
		user.setEnabled(true);
		userRepository.save(user);
	}*/

}
