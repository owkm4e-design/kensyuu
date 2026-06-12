package com.example.coffeeshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	//商品一覧ページ
	public String index(
			@RequestParam(name = "keyword", required = false) String keyword, //キーワード検索
			@RequestParam(name = "area", required = false) String area, //原産地検索
			@RequestParam(name = "price", required = false) Integer price, //値段検索
			@RequestParam(name = "order", required = false) String order,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {

		Page<Product> productPage;

		if (keyword != null && !keyword.isEmpty()) {

			if ("priceAsc".equals(order)) {
				productPage = productRepository
						.findByProductNameLikeOrderByPriceAsc("%" + keyword + "%", pageable);
			} else {
				productPage = productRepository
						.findByProductNameLikeOrderByCreatedAtDesc("%" + keyword + "%", pageable);
			}

		} else if (area != null && !area.isEmpty()) {

			if ("priceAsc".equals(order)) {
				productPage = productRepository
						.findByOriginLikeOrderByPriceAsc("%" + area + "%", pageable);
			} else {
				productPage = productRepository
						.findByOriginLikeOrderByCreatedAtDesc("%" + area + "%", pageable);
			}

		} else if (price != null) {

			if ("priceAsc".equals(order)) {
				productPage = productRepository
						.findByPriceLessThanEqualOrderByPriceAsc(price, pageable);
			} else {
				productPage = productRepository
						.findByPriceLessThanEqualOrderByCreatedAtDesc(price, pageable);
			}

		} else {

			if ("priceAsc".equals(order)) {
				productPage = productRepository.findAllByOrderByPriceAsc(pageable);
			} else {
				productPage = productRepository.findAllByOrderByCreatedAtDesc(pageable);
			}
		}

		model.addAttribute("productPage", productPage);
		model.addAttribute("keyword", keyword);
		model.addAttribute("area", area);
		model.addAttribute("price", price);
		model.addAttribute("order", order);

		return "product/index";
	}

	//複数の商品が並んだリストをコントローラに返す
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	//コントローラからもらった商品IDをもとに商品を探す
	public Product findById(Integer id) {
		return productRepository.findById(id).orElseThrow(
				() -> new RuntimeException("商品が見つかりません"));//存在しないIDだった場合エラーを返す
	}

}
