package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//画面表示するためにGET、"/"：/の後ろがあっているものと一致する
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World");//ControllerからHTML画面へデータを渡す命令
		return "index";//index⇒呼び出されるHTMLの名前
	}
}

