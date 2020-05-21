package com.joooahn.reservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "display_info")
@Data
public class DisplayInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Join Column은 @Column mapping 하지않음
//    @Column(name = "product_id")
//    private long productId;
    @Column(name = "opening_hours")
    String openingHours;
    @Column(name = "place_name")
    String placeName;
    @Column(name = "place_lot")
    String placeLot;
    @Column(name = "place_street")
    String placeStreet;
    @Column(name = "tel")
    String tel;
    @Column(name = "homepage")
    String homepage;
    @Column(name = "email")
    String email;
    @Column(name = "create_date")
    String createDate;
    @Column(name = "modify_date")
    String modifyDate;

    // inner join 하기 위해 양방향
    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
