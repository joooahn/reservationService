package com.joooahn.reservation.entity;

import com.joooahn.reservation.model.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Join Column은 @Column mapping 하지않음
//    @Column(name = "category_id")
//    private long categoryId;
    @Column(name = "description")
    private String description;
    @Column(name = "content")
    private String content;
    @Column(name = "event")
    private String event;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "modify_date")
    private Date modifyDate;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity")
    private List<DisplayInfoEntity> displayInfoEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity")
    private List<ProductImageEntity> productImageEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity")
    private List<PromotionEntity> promotionEntities;
}
