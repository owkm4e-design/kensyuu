package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data //getter,setter	の省略
@Table(name = "user") //userテーブルを使用
public class User implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")//名前
	private String name;

	@Column(name = "address")//住所
	private String address;

	@Column(name = "phone")//電話番号
	private String phone;

	@Column(name = "update_date")//更新日時
	private Date updateDate;

	@Column(name = "create_date")//登録日時
	private Date createDate;

	@Column(name = "delete_date")//削除日時
	private Date deleteDate;

}
