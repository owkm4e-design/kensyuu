package com.example.moattravel.service;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.param.billingportal.SessionCreateParams;

@Service
public class StripeService {

	//セッションを作成し、Stripeに必要な情報を渡す
	public String createStripeSession(String houseName,ReservationRregisterForm reservationRegisterForm,HttpServletRequest httpServletRequest) {
		Stripe.apiKey="";
		String requestUrl=new String(httpServletRequest.getRequestURL());
		SessionCreateParams params=SessionCreateParams.builder()
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.addLineItem(
						SessionCreateParams.LineItem.builder()
						.setPriceData(
								SessionCreateParams.LineItem.PriceData.builder()
								.setProductData(
										SessionCreateParams.LineItem.PriceData.ProductData.builder()
										.setName(houseName)
										build()
										.setUnitAmount((long)reservationRegisterForm.getAmount())
										.setCurrency)))
	}
}
