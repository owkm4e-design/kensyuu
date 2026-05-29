package com.example.moattravel.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {

	//宿泊人数が定員以下かどうかをチェックする
	public boolean isWithinCapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}

	//宿泊料金を計算する
	public Integer calculateAmount(LocalDate checkinDate,LocalDate checkoutDate,Integer price) {
		long number
	}
}
