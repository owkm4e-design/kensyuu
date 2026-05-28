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

	private final HouseRepository houseRepository;
	private final HouseService houseService;

	public AdminHouseController(HouseRepository houseRepository, HouseService houseService) {
		this.houseRepository = houseRepository;
		this.houseService = houseService;
	}

	@GetMapping
	public String index(Model model,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			@RequestParam(name = "keyword", required = false) String keyword) {
		Page<House> housePage;

		if (keyword != null && !keyword.isEmpty()) {
			housePage = houseRepository.findByNameLike("%" + keyword + "%", pageable);
		} else {
			housePage = houseRepository.findAll(pageable);
		}

		model.addAttribute("housesPage", housePage);
		model.addAttribute("keyword", keyword);

		return "admin/houses/index";
	}

	//民宿詳細ページ
	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id,
			Model model) {
		House house = houseRepository.getReferenceById(id);//URLのIDと一致するデータを取得する

		model.addAttribute("house", house);

		return "admin/houses/show";
	}

	@GetMapping("/register") //GETリクエストが来たらこのメソッドを実行
	public String register(Model model) {
		//houseRegisterFormという名前でHouseRegisterFormオブジェクトをHTMLへ渡す
		model.addAttribute("houseRegisterForm", new HouseRegisterForm());

		return "admin/houses/register";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute HouseRegisterForm houseRegisterForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {//リダイレクト先にデータを渡すための機能を提供するインタフェース

		if (bindingResult.hasErrors()) {
			return "admin/houses/register";

		}

		houseService.create(houseRegisterForm);//登録処理

		redirectAttributes.addFlashAttribute("successMessage", "民宿を登録しました。");//１回限り

		return "redirect:/admin/houses";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable(name = "id") Integer id, Model model) {
		House house = houseRepository.getReferenceById(id);

		String imageName = house.getImageName();

		//元の画像を直接編集するわけではないためnull
		HouseEditForm houseEditForm = new HouseEditForm(house.getId(), house.getName(), null, house.getDescription(),
				house.getPrice(), house.getCapacity(), house.getPostalCode(), house.getAddress(),
				house.getPhoneNumber());

		model.addAttribute("imageName", imageName);
		model.addAttribute("houseEditForm", houseEditForm);

		return "admin/houses/edit";
	}

	@PostMapping("/{id}/update") //既存の民宿情報を更新
	public String update(@ModelAttribute @Validated HouseEditForm houseEditForm,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "admin/houses/edit";

		}

		houseService.update(houseEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "民宿情報を編集しました。");

		return "redirect:/admin/houses";
	}

	@PostMapping("{id}/delete")//民宿情報の削除
	public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
		houseRepository.deleteById(id);

		redirectAttributes.addFlashAttribute("successMessage", "民宿を削除しました。");

		return "redirect:/admin/houses";
	}
}
