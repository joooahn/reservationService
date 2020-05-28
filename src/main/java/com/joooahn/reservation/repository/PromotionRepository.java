package com.joooahn.reservation.repository;

import java.util.List;

import com.joooahn.reservation.entity.PromotionEntity;
import com.joooahn.reservation.model.Promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {
	@Query("select DISTINCT a from PromotionEntity a join fetch a.productEntity b join fetch b.productImageEntities")
	List<PromotionEntity> findAll();
}
