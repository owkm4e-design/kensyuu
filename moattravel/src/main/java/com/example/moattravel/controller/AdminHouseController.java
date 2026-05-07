package com.example.moattravel.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moattravel.entity.House;
import com.example.moattravel.form.HouseRegisterForm;
import com.example.moattravel.repository.HouseRepository;

@Controller
@RequestMapping("/admin/houses")
public class AdminHouseController {
	private final HouseRepository houseRepository;//依存先のオブジェクトをfinalで宣言

	//コンストラクタで依存性の注入を行う
	public AdminHouseController(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

	@GetMapping //admin/housesがマッピングされている
	//コンストラクタが1つしかないときは@Aoutowiredを省略できる
	//@PageableDefault ページ番号、サイズ、並べ替える対象
	//@RequestParam フォームから送信されたパラメータをその引数に割り当てる
	public String index(Model model,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			@RequestParam(name = "keyword", required = false) String keyword) {
		//Page<House> housePage = houseRepository.findAll(pageable);
		Page<House> housePage;

		if (keyword != null && !keyword.isEmpty()) {
			housePage = houseRepository.findByNameLike("%" + keyword + "%", pageable);
		} else {
			housePage = houseRepository.findAll(pageable);
		}
		model.addAttribute("housePage", housePage);
		model.addAttribute("keyword", keyword);
		return "admin/houses/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {//@PathVariableaでURLの一部をその引数に割り当てることができる
		House house = houseRepository.getReferenceById(id);//指定したidを持つデータを1件取得できる
		model.addAttribute("house", house);
		return "admin/houses/show";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("houseRegisterForm", new HouseRegisterForm());
		return "admin/houses/register";
	}
}
