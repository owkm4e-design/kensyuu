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

		user.setEnabled(true);

		user.setRole(role);

		return userRepository.save(user);
	}

	//
	public UserEditForm createUserEditForm(Integer userId) {
		User user = findById(userId);

		return new UserEditForm(user.getId(), user.getName(), user.getFurigana(), user.getPostalCode(),
				user.getAddress(), user.getPhoneNumber(), user.getEmail());
	}

	//
	@Transactional
	public void update(UserEditForm userEditForm) {
		User user = userRepository.findById(userEditForm.getId()).orElseThrow();

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

	//
	public User findById(Integer id) {
		return userRepository.findById(id).orElseThrow();
	}

	//パスワード確認
	public boolean isSamePassword(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}
}
