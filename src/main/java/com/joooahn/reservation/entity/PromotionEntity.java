package com.joooahn.reservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="promotion")
@Data
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="product_id")
    private ProductEntity productEntity;
}
