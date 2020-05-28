package com.joooahn.reservation.controller;

import com.joooahn.reservation.model.PromotionResponse;
import com.joooahn.reservation.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionController {
    PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/promotions")
    public PromotionResponse getPromotions(){
        return promotionService.getPromotions();
    }
}
    