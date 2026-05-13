package com.example.moattravel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel.entity.Reservations;
import com.example.moattravel.entity.User;

public interface ReservationRepository extends JpaRepository<Reservations, Integer> {
	public Page<Reservations> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);

}
