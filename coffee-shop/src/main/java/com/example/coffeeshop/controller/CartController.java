package com.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coffeeshop.repository.CartItemRepository;
import com.example.coffeeshop.service.CartService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {

	private final CartItemRepository cartItemRepository;
	private final CartService cartService;

	//カートに商品を追加する
	@PostMapping("/add") //URLが/cart/add
	public String addCart(
			//@AuthenticationPrincipal LoginUser loginUser,
			@RequestParam Integer productId, //商品番号ID
			@RequestParam Integer gram, //購入グラム
			@RequestParam Integer quantity) //購入量
	{

		//CartServiceクラスに処理を丸投げ、商品IDとグラム、量の情報だけ渡す
		cartService.addCartItem(productId, gram, quantity);
		//cartService.addCartItem(loginUser.getUser(), productId, gram, quantity);

		return "redirect:/cart";//cartのURLへリダイレクト
	}

	//CartServiceクラスから結果を受取り、表示
	@GetMapping //URLが/cart
	public String cart(Model model) {

		model.addAttribute("cartItems", cartService.getCartItems());

		model.addAttribute("totalPrice", cartService.getTotalPrice());

		return "cart";//cart(HTML)
	}

	//カートから商品を１つ消す
	@PostMapping("/delete") //URLが/cart/delete
	public String deleteCartItem(@RequestParam Integer cartItemId) {
		cartService.deleteCartItem(cartItemId);//消したい明細のIDを受け取り、削除

		return "redirect:/cart";//cartのURLへリダイレクト
	}

	//カートに入った商品の数量変更
	@PostMapping("/decrease")
	public String decrease(@RequestParam Integer cartItemId) {
		cartService.decreaseQuantity(cartItemId);//数量変更のメソッドを呼び出す
		return "redirect:/cart";//カートにリダイレクトさせる
	}

	//数量変更後の更新画面
	@PostMapping("/update")
	public String update(@RequestParam Integer cartItemId, @RequestParam Integer quantity) {

		cartService.updateQuantity(cartItemId, quantity);

		return "redirect:/cart";
	}

	//注文確定
	@PostMapping("/order") //URLが/cart/order
	public String complete() {
		cartService.order();

		return "redirect:/cart/complete";//cart/completeのURLへリダイレクト
	}

	//注文完了
	@GetMapping("/complete") //URLが/cart/complete
	public String completePage() {

		return "order/complete";//order/complete(HTML)
	}

}
