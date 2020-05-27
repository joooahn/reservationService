package com.joooahn.reservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product_image")
@Data
public class ProductImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Join Column은 @Column mapping 하지않음
//    @Column(name = "product_id")
//    long productId;
    @Column(name = "type")
    private String type;
    @Column(name = "file_id")
    private long fileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
