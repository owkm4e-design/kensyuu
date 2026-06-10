package com.example.coffeeshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

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
