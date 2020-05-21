package com.joooahn.reservation.service;

import com.joooahn.reservation.entity.PromotionEntity;
import com.joooahn.reservation.model.Promotion;
import com.joooahn.reservation.model.PromotionResponse;
import com.joooahn.reservation.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionService {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public PromotionResponse getPromotions(){
        List<Promotion> items = new ArrayList<>();
        for(PromotionEntity pm : promotionRepository.findAll()){
            Promotion promotion = new Promotion();

            promotion.setId(pm.getId());
            promotion.setProductId(pm.getProductEntity().getId());
            String productImageUrl = "img/"+ pm.getProductEntity().getId() + "_th_" + pm.getProductEntity().getProductImageEntities().get(0).getId()+".png";
            promotion.setProductImageUrl(productImageUrl);

            items.add(promotion);
        }

        PromotionResponse promotionResponse = new PromotionResponse();
        promotionResponse.setItems(items);
        return promotionResponse;
    }
}
