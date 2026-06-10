package com.example.coffeeshop.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.coffeeshop.entity.Cart;
import com.example.coffeeshop.entity.CartItem;
import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.repository.CartItemRepository;
import com.example.coffeeshop.repository.CartRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CartService {

	private final CartRepository cartRepository;
	private final CartItemRepository cartItemRepository;
	private final ProductService productService;

	public void addCartItem(
			Integer productId,
			Integer gram,
			Integer quantity) {

		Cart cart = cartRepository.findById(1)
				.orElseThrow(() -> new IllegalArgumentException("カートが存在しません"));

		Product product = productService.findById(productId);

		CartItem cartItem = new CartItem();

		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setGram(gram);
		cartItem.setQuantity(quantity);

		cartItemRepository.save(cartItem);
	}
	/*B
	public void addCartItem(User user, Integer productId, Integer gram, Integer quantity) {
	
		Cart cart = cartRepository.findByUser(user).orElseGet(() -> {
			Cart newCart = new Cart();
			newCart.setUser(user);
	
			return cartRepository.save(newCart);
		});
	
		Product product = productService.findById(productId);
	
		CartItem cartItem = new CartItem();
	
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setGram(gram);
		cartItem.setQuantity(quantity);
	
		cartItemRepository.save(cartItem);
	
	}*/

	public List<CartItem> getCartItems() {
		Cart cart = cartRepository.findById(1).orElseThrow();

		return cartItemRepository.findByCart(cart);
	}

	public Integer getTotalPrice() {
		int total = 0;
		for (CartItem item : getCartItems()) {
			total += item.getProduct().getPrice() * item.getQuantity();
		}

		return total;
	}
}
