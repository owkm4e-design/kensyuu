package com.example.moattravel.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel.entity.Reservation;
import com.example.moattravel.entity.User;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	public Page<Reservation> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
}
