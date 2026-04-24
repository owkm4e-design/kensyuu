package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/*
 * ユーザ情報　Controller
 */
@Controller
public class UserController {

	/*
	 * ユーザ情報　Servise
	 */
	@Autowired
	private UserService userService;

	/*
	 * ユーザ情報一覧画面を表示
	 * @param model Model
	 * @return ユーザ情報一覧画面
	 */
	@GetMapping(value = "/user/list") //URLをさす
	public String displayList(Model model) {//ユーザサービスのメソッドを呼ぶ
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";//HTMLのuser.list(最初の表示画面)をさす
	}

	/*
	 * ユーザ新規登録画面を表示
	 * @param model Model
	 * @return ユーザ情報一覧画面
	 */
	@GetMapping(value = "/user/add")
	//「新規登録はこちら」が押されたときに行われるメソッド
	public String displayAdd(Model model) {
		return "user/add";//HTMLのuser.add(ダミー画面)
	}

	/*
	 * ユーザ情報詳細画面を表示
	 * @param id 表示するユーザID
	 * @param moel Model
	 * @return ユーザ情報詳細表示
	 */
	@GetMapping("/user/{id}")
	public String displayView(@PathVariable Long id, Model model) {
		return "user/view";
	}

}
