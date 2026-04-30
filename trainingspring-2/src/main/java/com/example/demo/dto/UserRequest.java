package com.example.demo.dto;

import java.io.Serializable;

import org.hibernate.annotations.processing.Pattern;

import lombok.Data;

@Data
public class UserRequest implements Serializable {

	@NotEmpty(message = "名前を入力してください")
	@Size(max = 100, message = "名前は100桁以内で入力してください")
	private String name;

	@Size(max = 255, message = "住所は255桁以内で入力してください")
	private String address;

	@Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message = "電話番号の形式で入力してください")
	private String phone;
}
