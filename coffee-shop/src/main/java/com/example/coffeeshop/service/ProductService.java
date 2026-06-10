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

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Integer id) {
		return productRepository.findById(id).orElseThrow(
				()-> new RuntimeException("商品が見つかりません"));
	}

}
