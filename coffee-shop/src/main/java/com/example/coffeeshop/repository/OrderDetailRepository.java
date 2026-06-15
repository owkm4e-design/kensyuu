
package com.example.coffeeshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffeeshop.entity.Order;
import com.example.coffeeshop.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	List<OrderDetail> findByOrder(Order order);
}
