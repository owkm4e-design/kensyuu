package com.example.moattravel.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class HouseRegisterForm {
	//@NotBlank 文字列がnullでなく、かつ空文字でないことを検証する
	@NotBlank(message = "民宿名を入力してください。")
	private String name;

	//imageFile ファイルをアップロードするための入力欄
	private MultipartFile imageFile;

	@NotBlank(message = "説明を入力してください。")
	private String description;

	//値がnullでないことを検証する
	@NotNull(message = "宿泊料金を入力してください。")
	@Min(value = 1, message = "宿泊料金は1円以上に設定して下さい。")
	private Integer price;

	@NotNull(message = "定員を入力してください。")
	@Min(value = 1, message = "定員は1人以上に設定してください。")
	private Integer capacity;

	@NotBlank(message = "郵便番号を入力してください。")
	private String postalCode;

	@NotBlank(message = "住所を入力してください。")
	private String address;

	@NotBlank(message = "電話番号を入力してください。")
	private String phoneNumber;

}
