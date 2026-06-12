package com.example.coffeeshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeeshop.entity.Product;

//全件取得、ID検索、保存、削除
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Page<Product> findByProductNameLikeOrderByPriceAsc(String keyword, Pageable pageable);

	Page<Product> findByProductNameLikeOrderByCreatedAtDesc(String keyword, Pageable pageable);

	Page<Product> findByOriginLikeOrderByPriceAsc(String area, Pageable pageable);

	Page<Product> findByOriginLikeOrderByCreatedAtDesc(String area, Pageable pageable);

	Page<Product> findByPriceLessThanEqualOrderByPriceAsc(Integer price, Pageable pageable);

	Page<Product> findByPriceLessThanEqualOrderByCreatedAtDesc(Integer price, Pageable pageable);

	Page<Product> findAllByOrderByPriceAsc(Pageable pageable);

	Page<Product> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
