package com.joooahn.reservation.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "category")
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryEntity")
    private List<ProductEntity> productEntities;
}
