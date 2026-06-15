package com.example.coffeeshop.service;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.entity.VerificationToken;
import com.example.coffeeshop.repository.VerificationTokenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VerificationTokenService {

	private final VerificationTokenRepository verificationTokenRepository;

	@Transactional
	public void create(User user, String token) {

		VerificationToken verificationToken = new VerificationToken();

		verificationToken.setUser(user);
		verificationToken.setToken(token);

		verificationTokenRepository.save(verificationToken);
	}

	//tokenの文字列で検索した結果を返す
	public VerificationToken getVerificationToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}
}
