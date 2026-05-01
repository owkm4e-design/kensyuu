package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired //必要な部品（クラス）を自動で用意して注入してくれる
	private UserService userService;//UserService をこのクラスで使えるように自動で準備しているコード

	//ユーザー情報一覧画面を表示
	@GetMapping(value = "/user/list") //user/listにアクセスされたら動く、ユーザー情報一覧画面の初期表示
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();//userServiceにsearchAll()を依頼しデータを取得
		model.addAttribute("userlist", userlist);//userlist(データ)を"userlist"という名前のModel箱にいれる
		return "user/list";//HTMLのuser/list	を表示
	}

	//ユーザー新規登録画面を表示
	@GetMapping(value = "/user/add") //usr/addにアクセスされたら動く、新規登録画面の初期表示
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new UserRequest());//新規情報を入れられるように空のUserRequestを作る
		return "user/add";//HTMLのuser/add	を表示
	}

	//ユーザー新規登録
	@RequestMapping(value = "/user/create", method = RequestMethod.POST) //value:URL（住所）、method:アクセス方法（送信方法）
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		//@Validated @ModelAttribute UserRequest userRequest:入力フォームの内容を受け取る
		//BindingResult result:入力エラーをいれる箱
		//Model model:画面へデータを渡す箱
		//@Validated:入力内容が正しいかチェック、@ModelAttribute:フォームの入力値をjavaオブジェクトに入れる
		if (result.hasErrors()) {
			//入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();//List<String>文字列だけを入れられるリスト
			for (ObjectError error : result.getAllErrors()) {//result.getAllErrors()の中から取り出した値をObjectError errorに入れる
				errorList.add(error.getDefaultMessage());//エラー文章だけ取り出して追加
			}
			model.addAttribute("validationError", errorList);//エラー内容を持って登録画面へ戻る
			return "user/add";//エラーメッセージ付きの登録画面を表示
		}
		//ユーザー情報の登録 正しく入力された場合
		userService.create(userRequest);
		return "redirect:/user/list";//この登録画面ではなくリスト画面を表示
	}

	//ユーザー情報詳細画面を表示
	@GetMapping("/user/{id}") //user/各id番号　にアクセスされたら動く
	public String displayView(@PathVariable Long id, Model model) {//@PathVariable：URLの中の数字や文字を取り出す
		return "user/view";//user/viewを表示
	}

}
