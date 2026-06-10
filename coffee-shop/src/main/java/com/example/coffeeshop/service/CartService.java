package com.example.coffeeshop.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.coffeeshop.entity.Cart;
import com.example.coffeeshop.entity.CartItem;
import com.example.coffeeshop.entity.Order;
import com.example.coffeeshop.entity.OrderDetail;
import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.repository.CartItemRepository;
import com.example.coffeeshop.repository.CartRepository;
import com.example.coffeeshop.repository.OrderDetailRepository;
import com.example.coffeeshop.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CartService {

	private final CartRepository cartRepository;
	private final CartItemRepository cartItemRepository;
	private final ProductService productService;

	private final OrderRepository orderRepository;
	private final OrderDetailRepository orderDetailRepository;

	//カートに商品を入れる
	public void addCartItem(
			Integer productId, //どの商品か
			Integer gram, //何グラム
			Integer quantity) //何個
	{

		//テスト用ID＝１のカートを持ってくる。DBになければエラーを出す
		Cart cart = cartRepository.findById(1)
				.orElseThrow(() -> new IllegalArgumentException("カートが存在しません"));

		//商品IDを使って商品の詳細情報を１つ持ってくる
		Product product = productService.findById(productId);

		//商品の重複を確認し、追加等行う
		CartItem cartItem = cartItemRepository.findByCartAndProductAndGram(cart, product, gram).orElse(null);

		//同じものがカートにいた場合
		if (cartItem != null) {
			cartItem.setQuantity(cartItem.getQuantity() + quantity);//新しく追加した分（quantity）を上乗せ
			//まだカートになかった場合
		} else {
			//新しい空のカートの明細を作る
			cartItem = new CartItem();

			//データを１つずつはめていく
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setGram(gram);
			cartItem.setQuantity(quantity);
		}
		//新しく作成したデータを保存
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

	//カートから所品を削除する
	public void deleteCartItem(Integer cartItemId) {
		cartItemRepository.deleteById(cartItemId);
	}

	//カートの中身を全部見る
	public List<CartItem> getCartItems() {
		Cart cart = cartRepository.findById(1).orElseThrow();

		return cartItemRepository.findByCart(cart);
	}

	//合計金額の計算
	public Integer getTotalPrice() {
		int total = 0;//０円で初期化しておく
		//カートに入っている明細を上から順に足していく
		for (CartItem item : getCartItems()) {
			total += item.getProduct().getPrice() * item.getQuantity();
		}

		return total;
	}

	//注文を確定する
	@Transactional
	public void order() {
		//DBからID＝１のカートを持ってくる
		Cart cart = cartRepository.findById(1).orElseThrow();

		//そのカートに入ってる明細を全件持ってくる
		List<CartItem> cartItems = cartItemRepository.findByCart(cart);

		//カートが空だったら処理終了
		if (cartItems.isEmpty()) {
			return;
		}

		//確定用の空のデータ箱を作る
		Order order = new Order();

		//カートに紐づいているユーザー情報を記録
		order.setUser(cart.getUser());
		order.setTotalPrice(getTotalPrice());//合計金額
		order.setStatus("注文済");//ステータスを注文済という文字にセット

		order = orderRepository.save(order);//保存

		//
		for (CartItem item : cartItems) {
			OrderDetail detail = new OrderDetail();

			detail.setOrder(order);
			detail.setProduct(item.getProduct());
			detail.setQuantity(item.getQuantity());

			detail.setPrice(item.getProduct().getPrice());

			orderDetailRepository.save(detail);
		}

		cartItemRepository.deleteAll(cartItems);
	}
}
