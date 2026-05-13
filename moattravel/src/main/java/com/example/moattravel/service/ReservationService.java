package com.example.moattravel.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	//宿泊人数が定員以下かどうかをチェックする
	public boolean isWithinCaapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}

	//宿泊料金を計算する
	public Integer calculateAmount(LocalDate checkinDate, LocalDate checkoutDate, Integer price) {
		//ChronoUnit.DAYS.between  2つの日付（LocalDate型）の間の日数を計算
		long numberOfNights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
		//金額×宿泊日数で宿泊料金を計算
		int amount = price * (int) numberOfNights;
		return amount;
	}

}
