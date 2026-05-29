package com.example.moattravel.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.moattravel.entity.Role;
import com.example.moattravel.entity.User;
import com.example.moattravel.form.SignupForm;
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
		user.setEnabled(true);

		return userRepository.save(user);
	}

	//メールアドレスが登録済かチェック
	public boolean isEmailRegisterd(String email) {
		User user = userRepository.findByEmail(email);//同じアドレスがないか探す
		return user != null;//検索結果がなしであれば未登録
	}

	//パスワードが確認用と一致しているかチェック
	public boolean isSamePassword(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}
}
