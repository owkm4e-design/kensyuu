
package com.example.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
