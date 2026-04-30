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
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/*
 * ユーザー情報 Controller
 */
@Controller
public class UserController {
	/*
	 * ユーザー情報 Service
	 */
	@Autowired
	private UserService userService;

	/*
	 * ユーザー情報一覧画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/user/list") //「/user/list」にアクセスされたら「displayList()」を動かす
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();//UserServiceから全ユーザーを取得してuserlistに保存する
		model.addAttribute("userlist", userlist);//"userlist"という名前でuserlist(データ)を画面へ渡す
		return "user/list";//HTMLのlistへ戻る
	}

	/*
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "user/add";
	}

	/*
	 * ユーザー新規登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST) //「method = RequestMethod.POST」通信方法はPOSTだけ受け付ける
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		//フォーム入力内容を UserRequest に入れて、チェックする、BindingResult result：入力チェック結果が入る箱、Model model：HTMLへデータを渡す箱

		if (result.hasErrors()) {//入力ミスがあるか
			//入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();//エラーメッセージを入れるリスト作成
			for (ObjectError error : result.getAllErrors()) {//全エラーを順番に確認
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/add";
		}
		//ユーザー情報の登録
		userService.create(userRequest);//DBへユーザー登録する
		return "redirect:/user/list";//登録したらこの画面ではなくlist画面へ戻す
	}

	/*
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/user/{id}") //{id}振られたIDの数字が入る
	public String displayView(@PathVariable Long id, Model model) {//@PathVariable Long id⇒URLの{id} の値を受け取る
		User user = userService.findById(id);//IDで探す
		model.addAttribute("userData", user);
		return "user/view";
	}

	/*
	 * ユーザー編集画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー編集画面
	 */
	@GetMapping("/user/{id}/edit")
	public String displayEdit(@PathVariable Long id, Model model) {
		User user = userService.findById(id);//DBから対象ユーザーを取得、IDの番号から詳細情報を取得
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();//編集フォーム専用の入れ物を新しく作る
		//DBから取った値をコピー
		userUpdateRequest.setId(user.getId());
		userUpdateRequest.setName(user.getName());
		userUpdateRequest.setPhone(user.getPhone());
		userUpdateRequest.setAddress(user.getAddress());
		model.addAttribute("userUpdateRequest", userUpdateRequest);//"userUpdateRequest" という名前でHTMLへ渡す
		return "user/edit";
	}

	/*
	 * ユーザー更新
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@RequestMapping(value = "/user/update", method = RequestMethod.POST) //更新内容を送るためPOST
	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();

			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/edit";
		}

		//ユーザー情報の更新
		userService.update(userUpdateRequest);
		//更新後の最新情報を見せるために詳細画面へ戻す
		return String.format("redirect:/user/%d", userUpdateRequest.getId());//String.format:文字列の中に値を埋め込んで文章を作る.%d:整数の場所
	}

	/*
	 * ユーザー情報削除
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/user/{id}/delete")
	public String delete(@PathVariable Long id, Model model) {
		//ユーザー情報の削除
		userService.delete(id);//指定IDのユーザー情報を削除する
		return "redirect:/user/list";//
	}

}
