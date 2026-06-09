
package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
