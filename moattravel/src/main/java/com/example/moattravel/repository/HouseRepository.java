package com.example.moattravel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel.entity.House;

public interface HouseRepository extends JpaRepository<House, Integer> {
	//findAll(),getReferenceById(id),save(エンティティ),delete(エンティティ),deleteById(id)

	//民宿名または目的地で検索する
	public Page<House> findByNameLike(String keyword, Pageable pageable);

	//エリア（都道府県）で検索する
	public Page<House> findByNameLikeOrAddressLike(String nameKeyword, String addressKeyword, Pageable pageable);

	//1泊あたりの予算（～円以内）で検索する
	public Page<House> findByAddressLike(String area, Pageable pageable);

	//指定された値以下であるデータを検索
	public Page<House> findByPriceLessThanEqual(Integer price, Pageable pageable);

	//findBy○○○OrderBy●●●Asc()とすれば昇順
	//findBy○○○OrderBy●●●Desc()とすれば降順

	//民宿名または目的地で検索する（新着順）
	public Page<House> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword,
			Pageable pageable);

	//民宿名または目的地で検索する（宿泊料金が安い順）
	public Page<House> findByNameLikeOrAddressLikeOrderByPriceAsc(String nameKeyword, String addressKeyword,
			Pageable pageable);

	//エリアで検索する（新着順）
	public Page<House> findByAddressLikeOrderByCreatedAtDesc(String area, Pageable pageable);

	//エリアで検索する（宿泊料金が安い順）
	public Page<House> findByAddressLikeOrderByPriceAsc(String area, Pageable pageable);

	//1泊あたりの予算で検索する（新着順）
	public Page<House> findByPriceLessThanEqualOrderByCreatedAtDesc(Integer price, Pageable pageable);

	//1泊あたりの予算で検索する（宿泊料金が安い順）
	public Page<House> findByPriceLessThanEqualOrderByPriceAsc(Integer price, Pageable pageable);

	//すべてのデータを取得する（新着順）
	public Page<House> findAllByOrderByCreatedAtDesc(Pageable pageable);

	//すべてのデータを取得する（宿泊料金が安い順）
	public Page<House> findAllByOrderByPriceAsc(Pageable pageable);
}
