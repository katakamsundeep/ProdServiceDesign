package com.scaler.productservicedecmwfevng.controller;

import com.scaler.productservicedecmwfevng.models.Product;
import com.scaler.productservicedecmwfevng.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;


    @Test
    void testGetAllProducts(){

        //arrange
        List<Product> productList = new ArrayList<>();
        Product p1= new Product();
        p1.setTitle("Samsung s22");
        productList.add(p1);

        Product p2= new Product();
        p2.setTitle("Samsung s23");
        productList.add(p2);

        Product p3= new Product();
        p3.setTitle("Samsung s24");
        productList.add(p3);

        //teting title comparisions
        List<Product> producttitleTest = new ArrayList<>();
        for(Product p: productList) {
            Product prodtest = new Product();
            prodtest.setTitle(p.getTitle());
            producttitleTest.add(prodtest);
        }
        when(
                productService.getAllProducts()
        ).thenReturn(
                productList
        );

//        when(
//                productService.getAllProducts()
//        ).thenReturn(
//                producttitleTest
//        );

        //act
        ResponseEntity<List<Product>> response = productController.getAllProducts();

        //asser
        List<Product> prodResponse = response.getBody();

        assertEquals(productList.size(), prodResponse.size());

        for(int i=0; i<prodResponse.size(); i++){

            assertEquals(productList.get(i).getTitle(),
                    prodResponse.get(i).getTitle());
        }

    }

}