package com.joooahn.reservation.controller;

import com.joooahn.reservation.model.CategoryResponse;
import com.joooahn.reservation.model.Product;
import com.joooahn.reservation.model.ProductResponse;
import com.joooahn.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    ProductResponse getProducts(@RequestParam("categoryId") int id, @RequestParam int start){
        return productService.getProducts(id, start);
    }
}
