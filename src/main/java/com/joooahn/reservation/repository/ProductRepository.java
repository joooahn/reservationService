package com.joooahn.reservation.repository;

import com.joooahn.reservation.entity.ProductEntity;
import com.joooahn.reservation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
