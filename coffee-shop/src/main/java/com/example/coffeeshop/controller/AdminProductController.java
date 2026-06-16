package com.example.coffeeshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.form.ProductEditForm;
import com.example.coffeeshop.form.ProductRegisterForm;
import com.example.coffeeshop.service.ProductService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/products")
@AllArgsConstructor
//管理者用の商品窓口
public class AdminProductController {

	private final ProductService productService;

	@GetMapping
	//（管理者用）商品一覧ページ表示
	public String index(Model model) {
		List<Product> products = productService.findAll();

		model.addAttribute("products", products);

		return "admin/products/index";
	}

	@GetMapping("/{id}")
	//（管理者用）商品詳細ページの表示
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		Product product = productService.findById(id);

		model.addAttribute("product", product);

		return "admin/products/show";

	}

	@GetMapping("/register")
	//商品登録画面表示
	public String register(Model model) {
		model.addAttribute("productRegisterForm", new ProductRegisterForm());

		return "admin/products/register";
	}

	@PostMapping("/create")
	//商品の新規登録
	public String create(@ModelAttribute ProductRegisterForm productRegisterForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "admin/products/register";
		}

		productService.create(productRegisterForm);//登録処理

		redirectAttributes.addFlashAttribute("successMessage", "登録しました");

		return "redirect:/admin/products";
	}

	@GetMapping("/{id}/edit")
	//商品の編集画面表示
	public String edit(@PathVariable(name = "id") Integer id, Model model) {
		Product product = productService.findById(id);
		String imageName = product.getImageFileName();

		ProductEditForm productEditForm = new ProductEditForm(product.getId(), product.getProductName(),
				product.getOrigin(), product.getRoastLevel(), product.getDescription(), product.getPrice(), null);

		model.addAttribute("imageName", imageName);
		model.addAttribute("productEditForm", productEditForm);

		return "admin/products/edit";
	}

	@PostMapping("/{id}/update")
	//商品の編集⇒更新
	public String update(@ModelAttribute @Validated ProductEditForm productEditForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "admin/products/edit";
		}

		productService.update(productEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "編集しました。");

		return "redirect:/admin/products";
	}

	@PostMapping("/{id}/delete")
	//商品の編集⇒登録情報の削除
	public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {

		productService.deleteById(id);

		redirectAttributes.addFlashAttribute("successMessage", "削除しました");

		return "redirect:/admin/products";
	}
}
