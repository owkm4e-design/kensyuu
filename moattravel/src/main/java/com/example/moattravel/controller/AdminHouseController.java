package com.example.moattravel.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.moattravel.entity.House;
import com.example.moattravel.form.HouseEditForm;
import com.example.moattravel.form.HouseRegisterForm;
import com.example.moattravel.repository.HouseRepository;
import com.example.moattravel.service.HouseService;

@Controller
@RequestMapping("/admin/houses")
public class AdminHouseController {
	private final HouseRepository houseRepository;//依存先のオブジェクトをfinalで宣言
	private final HouseService houseService;

	//コンストラクタで依存性の注入を行う
	public AdminHouseController(HouseRepository houseRepository, HouseService houseService) {
		this.houseRepository = houseRepository;
		this.houseService = houseService;
	}

	//
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

	//詳細ページ
	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {//@PathVariableaでURLの一部をその引数に割り当てることができる
		House house = houseRepository.getReferenceById(id);//指定したidを持つデータを1件取得できる
		model.addAttribute("house", house);
		return "admin/houses/show";
	}

	//登録ページ
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("houseRegisterForm", new HouseRegisterForm());
		return "admin/houses/register";
	}

	//フォームの送信先
	@PostMapping("/create")
	public String create(@ModelAttribute @Validated HouseRegisterForm houseRegisterForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {//エラーのチェック
			return "admin/houses/register";
		}

		houseService.create(houseRegisterForm);
		redirectAttributes.addFlashAttribute("successMessage", "民宿を登録しました。");//addFlashAttribute リダイレクトの直後に1回限り利用するデータを渡す

		return "redirect:/admin/houses";//民宿一覧ページにリダイレクト
	}

	//民宿編集ページ
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable(name = "id") Integer id, Model model) {
		House house = houseRepository.getReferenceById(id);
		//民宿画像のファイル名を取得
		String imageName = house.getImageName();
		//フォームクラスをインスタンス化する
		HouseEditForm houseEditForm = new HouseEditForm(house.getId(), house.getName(), null, house.getDescription(),
				house.getPrice(), house.getCapacity(), house.getPostalCode(), house.getAddress(),
				house.getPhoneNumber());
		//民宿画像のファイル名をビューに渡す
		model.addAttribute("imageName", imageName);
		//生成したインスタンスをビューに渡す
		model.addAttribute("houseEditForm", houseEditForm);
		return "admin/houses/edit";
	}

	//フォームの送信先
	@PostMapping("/{id}/update")
	public String update(@ModelAttribute @Validated HouseEditForm houseEditForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "admin/houses/edit";
		}

		houseService.update(houseEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "民宿情報を編集しました。");

		return "redirect:/admin/houses";
	}
}
