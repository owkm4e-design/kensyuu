package com.example.coffeeshop.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.repository.UserRepository;

import lombok.AllArgsConstructor;

//UserDetailsImplクラスのインスタンスを生成
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	//メールアドレス（ID）を預かり、DBから探す、権限取得、
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			//メールアドレスでユーザー検索
			User user = userRepository.findByEmail(email);
			//ユーザーが持つ権限（ADMIN）等の「名前」を取得
			String userRoleName = user.getRole().getRoleName();
			//権限リストの箱を作成
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			//新しく作った権限リストの箱に権限を追加する
			authorities.add(new SimpleGrantedAuthority(userRoleName));
			//UserDetailsImplにユーザー情報と権限情報を渡す
			return new UserDetailsImpl(user, authorities);

		} catch (Exception e) {
			throw new UsernameNotFoundException("ユーザーが見つかりませんでした。");
		}

	}

}
