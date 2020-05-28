package com.joooahn.reservation.entity;

import com.joooahn.reservation.model.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity")
    private List<DisplayInfoEntity> displayInfoEntities = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity")
    private List<ProductImageEntity> productImageEntities = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity")
    private List<PromotionEntity> promotionEntities = new ArrayList<>();
}
