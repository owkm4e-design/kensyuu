package com.example.coffeeshop.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//商品名
	@Column()
	private String productname;

	//原産地名
	private String origin;

	//焙煎度合
	private String roastLevel;

	//金額
	private Integer price;

	//在庫
	private Integer stock;

	//商品画像ファイル名
	private String imageFileName;

	//商品説明
	@Column(length = 2000)
	private String description;

	//作成日時
	private LocalDateTime createdAt;

	//更新日時
	private LocalDateTime updatedAt;

	

}
