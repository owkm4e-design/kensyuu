package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
