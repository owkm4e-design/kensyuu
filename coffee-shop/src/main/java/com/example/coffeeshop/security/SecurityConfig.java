package com.example.coffeeshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Springの設定
@EnableWebSecurity //セキュリティ機能
@EnableMethodSecurity //メソッドごとのセキュリティ機能
public class SecurityConfig {

	@Bean //オブジェクトをSpring管理にする
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean //オブジェクトをSpring管理にする
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				//URLごとの権限制御
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/", "/login", "/signup/**", "/product/**","/images/**",// "/js/**","/css/**","/storage/**", "/stripe/webhook"
								"/storage/**")
						.permitAll()//すべてのユーザーに許可
						.requestMatchers("/admin/**").hasRole("ADMIN")//管理者のみ許可
						.anyRequest().authenticated()//上記以外はログインが必要
				)
				
				//ログイン設定
				.formLogin((form) -> form
						.loginPage("/login")//ログインページのURL
						.loginProcessingUrl("/login")//ログインフォームの送信先URL
						.defaultSuccessUrl("/?loggedIn")//ログイン成功時のリダイレクト先URL
						.failureUrl("/login?error")//ログイン失敗時のリダイレクト先URL
						.permitAll())

				//ログアウト設定
				.logout((logout) -> logout
						.logoutSuccessUrl("/?loggedout")//ログアウト時のリダイレクト先URL
						.permitAll())
				
				
				//CSRF対策設定
				.csrf((csrf) -> csrf
						.ignoringRequestMatchers("/stripe/webhook"));
				

		return http.build();
	}
}
