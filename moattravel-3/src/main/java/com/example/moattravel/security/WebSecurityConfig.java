package com.example.moattravel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //セキュリティ機能を有効にし、認証・認可のルールやログイン・ログアウト処理など各種設定を行える
@EnableMethodSecurity //メソッドレベルでのセキュリティ機能を有効にする
public class WebSecurityConfig {

	@Bean //戻り値がDIコンテナに登録される
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/css/**", "/images/**", "/js/**", "/storage/**", "/").permitAll()//すべてのユーザーにアクセス許可するURL
						.requestMatchers("/admin/**").hasRole("ADMIN")//管理者のみにアクセス許可するURL
						.anyRequest().authenticated()//上記以外のURLはログインが必要（会員または管理者のどちらでもOK）
				)
				.formLogin((form) -> form
						.loginPage("/login")//ログインぺージのURL
						.loginProcessingUrl("/login")//ログインフォームの送信先URL
						.defaultSuccessUrl("/?loggedIn")//ログイン成功時のリダイレクト先URL
						.failureUrl("/login?error")//ログイン失敗時のリダイレクト先URL
						.permitAll())
				.logout((logout) -> logout
						.logoutSuccessUrl("/?loggedOut")//ログアウト時のリダイレクト先URL
						.permitAll());

		return http.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();//BCryptはパスワード用のハッシュ値を生成してくれる
	}
}
