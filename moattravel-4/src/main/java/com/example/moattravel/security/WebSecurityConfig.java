package com.example.moattravel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration//設定用のクラス
@EnableWebSecurity//セキュリティ機能を有効
@EnableMethodSecurity//メソッドのセキュリティ機能
public class WebSecurityConfig {

	@Bean//DIコンテナに登録されたインスタンス
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/css/**", "/images/**", "/js/**", "/storage/**", "/").permitAll()//すべてのユーザーに許可
						.requestMatchers("/admin/**").hasRole("ADMIN")//管理者のみ許可
						.anyRequest().authenticated()//上記以外はログインが必要
				)

				.formLogin((form) -> form
						.loginPage("/login")//ログインページのURL
						.loginProcessingUrl("/login")//ログインフォームの送信先URL
						.defaultSuccessUrl("/?loggedIn")//ログイン成功時のリダイレクト先URL
						.failureUrl("/login?error")//ログイン失敗時のリダイレクト先URL
						.permitAll())

				.logout((logout) -> logout
						.logoutSuccessUrl("/?loggedout")//ログアウト時のリダイレクト先URL
						.permitAll());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
