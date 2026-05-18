package com.example.moattravel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel.entity.House;

public interface HouseRepository extends JpaRepository<House, Integer> {//<エンティティのクラス型,主キーのデータ型>
	public Page<House> findByNameLike(String keyword, Pageable pageable);
}
