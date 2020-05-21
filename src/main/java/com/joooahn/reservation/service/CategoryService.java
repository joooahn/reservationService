package com.joooahn.reservation.service;

import com.joooahn.reservation.entity.CategoryEntity;
import com.joooahn.reservation.entity.ProductEntity;
import com.joooahn.reservation.model.Category;
import com.joooahn.reservation.repository.CategoryRepository;
import com.joooahn.reservation.model.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse getCategories(){
        List<Category> item = new ArrayList<Category>();
        List<CategoryEntity> list = categoryRepository.findAll();

        for(CategoryEntity it : list){
            Category category = new Category();
            category.setId((int)it.getId());
            category.setName(it.getName());

            // category : product => 1:N 관계
            // product : displayInfo => 1:N 관계이므로
            // category 1개에 해당되는 N개의 product를 순회하며, product에 대응되는 DisplayInfo의 개수를 count
            int cnt = 0;
            if(it.getProductEntities() != null){
                for(ProductEntity pr : it.getProductEntities()){
                    if(pr.getDisplayInfoEntities() != null)
                        cnt += pr.getDisplayInfoEntities().size();
                }
            }
            category.setCount(cnt);
            item.add(category);
        }

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setItems(item);
        return categoryResponse;
    }
}
