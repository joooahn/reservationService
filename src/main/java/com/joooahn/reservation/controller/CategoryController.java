package com.joooahn.reservation.controller;

import com.joooahn.reservation.entity.CategoryEntity;
import com.joooahn.reservation.model.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.joooahn.reservation.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    CategoryResponse getCategory(){
        return categoryService.getCategories();
    }
}
