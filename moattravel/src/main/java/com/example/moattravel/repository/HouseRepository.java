package com.example.moattravel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel.entity.House;

public interface HouseRepository extends JpaRepository<House, Integer> {
	//findAll(),getReferenceById(id),save(エンティティ),delete(エンティティ),deleteById(id)
	public Page<House> findByNameLike(String keyword, Pageable pageable);

	public Page<House> findByNameLikeOrAddressLike(String namekeyword, String addresskeyword, Pageable pageable);

	public Page<House> findByAddressLike(String area, Pageable pageable);

	public Page<House> findByPriceLessThanEqual(Integer price, Pageable pageable);//指定された値以下であるデータを検索
}
