package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffeeshop.entity.Product;

//全件取得、ID検索、保存、削除
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
