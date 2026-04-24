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

/*
 * ユーザ情報　entity
 */
@Entity
@Data //getter,setterの省略
@Table(name = "user") //ユーザテーブルを使う
public class User implements Serializable {
	/*
	 * ID
	 */
	@Id
	@Column(name = "id") //DBのidのカラム
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/*
	 * 名前
	 */
	@Column(name = "name") //DBのnameのカラム
	private String name;
	/*
	 * 住所
	 */
	@Column(name = "address") //DBのaddressのカラム
	private String address;
	/*
	 * 電話番号
	 */
	@Column(name = "phone") //DBのphoneのカラム
	private String phone;
	/*
	 * 更新日時
	 */
	@Column(name = "update_date") //DBのupdate_dateのカラム
	private Date updateDate;
	/*
	 * 登録日時
	 */
	@Column(name = "create_date") //DBのcreate_dateのカラム
	private Date createDate;
	/*
	 * 削除日時
	 */
	@Column(name = "delete_date") //DBのdelete_dateのカラム
	private Date deleteDate;
}
