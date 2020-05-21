package com.joooahn.reservation.service;

import com.joooahn.reservation.entity.CategoryEntity;
import com.joooahn.reservation.entity.DisplayInfoEntity;
import com.joooahn.reservation.entity.ProductEntity;
import com.joooahn.reservation.model.Product;
import com.joooahn.reservation.model.ProductResponse;
import com.joooahn.reservation.repository.CategoryRepository;
import com.joooahn.reservation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ProductResponse getProducts(int categoryId, int start){
        ProductResponse productResponse = new ProductResponse();
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElseThrow(IllegalArgumentException::new);
        List<ProductEntity> prList = categoryEntity.getProductEntities();
        List<Product> item = new ArrayList<Product>();
        productResponse.setTotalCount(prList.size());

        if(start < 0)
            start = 0;

        for(int i = start; i < start+4; i++){

            if(i >= productResponse.getTotalCount()) break;

            Product product = new Product();
            ProductEntity pr = prList.get(i);

            product.setProductContent(pr.getContent());
            product.setProductDescription(pr.getDescription());
            product.setProductId(pr.getId());
            product.setProductImageUrl("img/"+ pr.getId() + "_th_" + pr.getProductImageEntities().get(0).getId()+".png");

            for(DisplayInfoEntity dis : pr.getDisplayInfoEntities()){
                product.setDisplayInfoId(dis.getId());
                product.setPlaceName(dis.getPlaceName());
            }
            item.add(product);
        }

        productResponse.setItems(item);
        productResponse.setTotalCount(prList.size());
        return productResponse;
    }
}
