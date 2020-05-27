package com.joooahn.reservation.repository;

import com.joooahn.reservation.entity.CategoryEntity;
import com.joooahn.reservation.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
	@Query("select DISTINCT a from CategoryEntity a join fetch a.productEntities b")
	List<CategoryEntity> findAll();
}
