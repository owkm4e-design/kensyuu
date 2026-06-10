
package com.example.coffeeshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.Cart;
import com.example.coffeeshop.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	List<CartItem> findByCart(Cart cart);
}
