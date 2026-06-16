package com.example.coffeeshop.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.form.ProductEditForm;
import com.example.coffeeshop.form.ProductRegisterForm;
import com.example.coffeeshop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	//商品の登録機能
	@Transactional
	public void create(ProductRegisterForm productRegisterForm) {
		Product product = new Product();
		MultipartFile imageFile = productRegisterForm.getImageFile();

		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			String hashedImageName = generateNewFileName(imageName);

			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);

			copyImageFile(imageFile, filePath);

			product.setImageFileName(hashedImageName);
		}

		product.setProductName(productRegisterForm.getProductName());
		product.setOrigin(productRegisterForm.getOrigin());
		product.setRoastLevel(productRegisterForm.getRoastLevel());
		product.setDescription(productRegisterForm.getDescription());
		product.setPrice(productRegisterForm.getPrice());

		productRepository.save(product);

	}

	//商品の更新
	@Transactional
	public void update(ProductEditForm productEditForm) {
		Product product = findById(productEditForm.getId());
		MultipartFile imageFile = productEditForm.getImageFile();

		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile, filePath);
			product.setImageFileName(hashedImageName);

		}
		
		product.setProductName(productEditForm.getProductName());
		product.setOrigin(productEditForm.getOrigin());
		product.setRoastLevel(productEditForm.getRoastLevel());
		product.setDescription(productEditForm.getDescription());
		product.setPrice(productEditForm.getPrice());

		productRepository.save(product);

	}

	//ファイル名の変更処理
	public String generateNewFileName(String fileName) {
		String[] fileNames = fileName.split("\\.");

		for (int i = 0; i < fileNames.length - 1; i++) {
			fileNames[i] = UUID.randomUUID().toString();
		}
		String hashedFileName = String.join(".", fileNames);

		return hashedFileName;
	}

	//ファイルのコピー処理
	public void copyImageFile(MultipartFile imageFile, Path filePath) {
		try {
			Files.copy(imageFile.getInputStream(), filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//商品の検索機能
	public Page<Product> search(
			String keyword,
			String area,
			Integer price,
			String order,
			Pageable pageable) {

		if (keyword != null && !keyword.isEmpty()) {

			if ("priceAsc".equals(order)) {
				return productRepository
						.findByProductNameLikeOrderByPriceAsc("%" + keyword + "%", pageable);
			} else {
				return productRepository
						.findByProductNameLikeOrderByCreatedAtDesc("%" + keyword + "%", pageable);
			}

		} else if (area != null && !area.isEmpty()) {

			if ("priceAsc".equals(order)) {
				return productRepository
						.findByOriginLikeOrderByPriceAsc("%" + area + "%", pageable);
			} else {
				return productRepository
						.findByOriginLikeOrderByCreatedAtDesc("%" + area + "%", pageable);
			}

		} else if (price != null) {

			if ("priceAsc".equals(order)) {
				return productRepository
						.findByPriceLessThanEqualOrderByPriceAsc(price, pageable);
			} else {
				return productRepository
						.findByPriceLessThanEqualOrderByCreatedAtDesc(price, pageable);
			}

		} else {

			if ("priceAsc".equals(order)) {
				return productRepository.findAllByOrderByPriceAsc(pageable);
			} else {
				return productRepository.findAllByOrderByCreatedAtDesc(pageable);
			}
		}

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

	//削除
	@Transactional
	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

}
