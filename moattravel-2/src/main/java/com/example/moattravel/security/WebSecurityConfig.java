package com.example.moattravel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //メソッドに@Beanアノテーションをつけるために必要
@EnableWebSecurity //認証・認可のルールやログイン・ログアウト処理など各種設定を行えるように
@EnableMethodSecurity //メソッドレベルでのセキュリティ機能を有効にする
public class WebSecurityConfig {

	@Bean //そのメソッドの戻り値（インスタンス）がDIコンテナに登録される
	public SecurityFilterChain securityFilterCgain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/css/**", "/images/**", "/js/**",
								"/storage/**", "/", "/signup/**", "/houses", "/houses/{id}")
						.permitAll() // すべてのユーザーにアクセスを許可するURL
						.requestMatchers("/admin/**").hasRole("ADMIN") // 管理者にのみアクセスを許可するURL
						.anyRequest().authenticated()// 上記以外のURLはログインが必要（会員または管理者のどちらでもOK）
				)

				.formLogin((form) -> form
						.loginPage("/login")// ログインページのURL
						.loginProcessingUrl("/login")// ログインフォームの送信先URL
						.defaultSuccessUrl("/?loggedIn") // ログイン成功時のリダイレクト先URL
						.failureUrl("/login?error")// ログイン失敗時のリダイレクト先URL
						.permitAll())

				.logout((logout) -> logout
						.logoutSuccessUrl("/?loggedOut")
						.permitAll());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		//BCryptはパスワード用のハッシュ値を生成してくれる強力なハッシュアルゴリズム
		return new BCryptPasswordEncoder();
	}

}
