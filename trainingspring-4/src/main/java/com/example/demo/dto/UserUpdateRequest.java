package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * ユーザー情報更新　リクエストデータ
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateRequest extends UserRequest implements Serializable {
	/*
	 * 名前
	 */
	@NotNull
	private Long id;
}
