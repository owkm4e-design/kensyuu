
package com.example.coffeeshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.Cart;
import com.example.coffeeshop.entity.CartItem;
import com.example.coffeeshop.entity.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	List<CartItem> findByCart(Cart cart);
	
	Optional<CartItem>findByCartAndProductAndGram(Cart cart,Product product,Integer gram);
}
