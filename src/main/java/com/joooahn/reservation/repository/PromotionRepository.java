package com.joooahn.reservation.repository;

import com.joooahn.reservation.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {
}
