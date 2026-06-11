package com.example.coffeeshop.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.coffeeshop.entity.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

	private final User user;//ユーザー情報を取り出す
	private final Collection<GrantedAuthority> authorities;

	//ログイン後にID、パス以外のユーザー情報を取出せる
	public User getUser() {
		return user;
	}

	@Override
	//ユーザーごとの権限リストを返す。URLのアクセス制限
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	//ログインパスワード
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	//ログインID(メールアドレスをIDとする)
	public String getUsername() {

		return user.getEmail();
	}

	@Override
	//アカウントの有効期限
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	//アカウントのロック状態をチェック（5回間違えたら凍結等）
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	//パスワードの有効期限切れをチェック
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	//アカウントの有効・無効チェック
	public boolean isEnabled() {
		return user.getEnabled();
	}

}
