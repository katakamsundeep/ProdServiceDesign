package com.scaler.productservicedecmwfevng.services;

import com.scaler.productservicedecmwfevng.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfevng.models.Category;
import com.scaler.productservicedecmwfevng.models.Product;
import com.scaler.productservicedecmwfevng.repositories.CategoryRepository;
import com.scaler.productservicedecmwfevng.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("SelfCategorySerivce")
public class SelfCategorySerivce implements CategoryService{

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public SelfCategorySerivce(ProductRepository productRepository,
                               CategoryRepository categoryRepository){

        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }


    @Override
    public List<Category> getAllCategories()  {

        List<Category> categoryList = new ArrayList<>();

        categoryList = categoryRepository.findAll();

        if(!categoryList.isEmpty()) {

            return categoryList;
        }
        for (Category category : categoryList) {
            categoryList.add(category);
        }
        return categoryList;
    }


}
