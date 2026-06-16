package com.example.moattravel.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.moattravel.entity.Role;
import com.example.moattravel.entity.User;
import com.example.moattravel.form.SignupForm;
import com.example.moattravel.form.UserEditForm;
import com.example.moattravel.repository.RoleRepositpry;
import com.example.moattravel.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	private final RoleRepositpry roleRepositpry;

	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, RoleRepositpry roleRepositpry, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepositpry = roleRepositpry;
		this.passwordEncoder = passwordEncoder;
	}

	//会員登録
	@Transactional
	public User create(SignupForm signupForm) {
		User user = new User();
		Role role = roleRepositpry.findByName("ROLE_GENERAL");//基本一般のみ

		user.setName(signupForm.getName());
		user.setFurigana(signupForm.getFurigana());
		user.setPostalCode(signupForm.getPostalCode());
		user.setAddress(signupForm.getAddress());
		user.setPhoneNumber(signupForm.getPhoneNumber());
		user.setEmail(signupForm.getEmail());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));//ハッシュ化
		user.setRole(role);
		user.setEnabled(false);

		return userRepository.save(user);
	}

	//会員情報の更新
	@Transactional
	public void update(UserEditForm userEditForm) {
		User user = userRepository.getReferenceById(userEditForm.getId());

		user.setName(userEditForm.getName());
		user.setFurigana(userEditForm.getFurigana());
		user.setPostalCode(userEditForm.getPostalCode());
		user.setAddress(userEditForm.getAddress());
		user.setPhoneNumber(userEditForm.getPhoneNumber());
		user.setEmail(userEditForm.getEmail());

		userRepository.save(user);
	}

	//メールアドレスが登録済かチェック
	public boolean isEmailRegistered(String email) {
		User user = userRepository.findByEmail(email);//同じアドレスがないか探す
		return user != null;//検索結果がなしであれば未登録
	}

	//パスワードが確認用と一致しているかチェック
	public boolean isSamePassword(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}

	//ユーザーを有効にする(利用再開と共通)
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

	//管理用のID検索
	public User findById(Integer id) {
		return userRepository.findById(id).orElseThrow();
	}

	//メールアドレスが変更されたかチェックする
	public boolean isEmailChanged(UserEditForm userEditForm) {
		User currentUser = userRepository.getReferenceById(userEditForm.getId());
		return !userEditForm.getEmail().equals(currentUser.getEmail());
	}
}
