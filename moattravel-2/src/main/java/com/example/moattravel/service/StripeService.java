package com.example.moattravel.service;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.moattravel.form.ReservationRegisterForm;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
public class StripeService {
	@Value("{stripe.api-key}")
	private String stripeApiKey;

	//セッションを作成し、Stripeに必要な情報を返す
	public String createStripeSession(String houseName, ReservationRegisterForm reservationRegisterForm,
			HttpServletRequest httpServletRequest) {
		Stripe.apiKey = stripeApiKey;
		String requestUrl = new String(httpServletRequest.getRequestURL());
		SessionCreateParams params = SessionCreateParams.builder()
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)//支払方法をカード決済に設定
				.addLineItem(SessionCreateParams.LineItem.builder().setPriceData(
						SessionCreateParams.LineItem.PriceData.builder()
								.setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
										.setName(houseName).build())//商品情報
								.setUnitAmount((long) reservationRegisterForm.getAmount())//支払い金額
								.setCurrency("jpy")//通貨
								.build())
						.setQuantity(1L)//数量
						.build())
				.setMode(SessionCreateParams.Mode.PAYMENT)//決済モード
				.setSuccessUrl(//決済成功時のURL
						requestUrl.replaceAll("/houses/[0-9]+/reservations/confirm", "") + "/reservations?reserved")
				.setCancelUrl(requestUrl.replace("/reservations/confirm", ""))//キャンセル時のURL
				.setPaymentIntentData(//決済の紐付くデータ
						SessionCreateParams.PaymentIntentData.builder()
								.putMetadata("houseId", reservationRegisterForm.getHouseId().toString())
								.putMetadata("userId", reservationRegisterForm.getUserId().toString())
								.putMetadata("checkinDate", reservationRegisterForm.getCheckinDate())
								.putMetadata("checkoutDate", reservationRegisterForm.getCheckoutDate())
								.putMetadata("numberOfPeople", reservationRegisterForm.getNumberOfPeople().toString())
								.putMetadata("amount", reservationRegisterForm.getAmount().toString())
								.build())
				.build();
		try {
			Session session = Session.create(params);
			return session.getId();
		} catch (StripeException e) {
			e.printStackTrace();
			return "";
		}

	}
}
