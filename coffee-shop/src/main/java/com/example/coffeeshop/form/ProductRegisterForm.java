package com.example.coffeeshop.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductRegisterForm {

	@NotBlank(message = "商品名を入力してください。")
	private String productName;

	@NotBlank(message = "原産地名を入力してください。")
	private String origin;

	@NotBlank(message = "焙煎度合を入力してください。")
	private String roastLevel;

	@NotBlank(message = "説明を入力してください。")
	private String description;

	@NotNull(message = "金額/100gを入力してください。")
	@Min(value = 1, message = "金額は１円以上に設定して下さい。")
	private Integer price;

	private MultipartFile imageFile;

}
