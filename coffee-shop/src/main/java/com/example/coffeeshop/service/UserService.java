package com.example.coffeeshop.service;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.coffeeshop.entity.Role;
import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.form.SignupForm;
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
		Role role = roleRepository.findByName("ROLE_GENERAL");

		user.setName(signupForm.getName());
		user.setFurigana(signupForm.getFurigana());
		user.setPostalCode(signupForm.getPostalCode());
		user.setAddress(signupForm.getAddress());
		user.setPhoneNumber(signupForm.getPhoneNumber());
		user.setEmail(signupForm.getEmail());

		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));

		user.setEnabled(true);

		user.setRole(roleRepository.findById(1).orElseThrow());

		return userRepository.save(user);
	}

	//メアド確認
	public boolean isEmailRegistered(String email) {
		User user = userRepository.findByEmail(email);

		return user != null;
	}

	//パスワード確認
	public boolean isSamePassword(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}
}
