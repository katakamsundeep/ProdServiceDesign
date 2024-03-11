package com.scaler.productservicedecmwfevng.controller;

import com.scaler.productservicedecmwfevng.models.Category;
import com.scaler.productservicedecmwfevng.models.Product;
import com.scaler.productservicedecmwfevng.services.CategoryService;
import com.scaler.productservicedecmwfevng.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(@Qualifier("SelfCategorySerivce") CategoryService categoryService){

        this.categoryService=categoryService;
    }

    @GetMapping()   // localhost:8080/categories
    public List<Category> getAllCategories(){

//        List<Category> categoryList = categoryService.getAllCategories();

//        JUNIT TeST Purpose
//        List<Product> junitProcutlist = new ArrayList<>();
//
//        for(int i=0; i<2; i++){
//            junitProcutlist.add(productList.get(i));
//        }


//        for(Product p: productList){
//            p.setTitle("Hello " + p.getTitle());
//            junitProcutlist.add(p);
//        }
//        ResponseEntity<List<Category>> response = new ResponseEntity<>(categoryList, HttpStatus.FORBIDDEN);



        return categoryService.getAllCategories();
    }



}
