package com.scaler.productservicedecmwfevng.controller;

import com.scaler.productservicedecmwfevng.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfevng.models.Product;
import com.scaler.productservicedecmwfevng.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService){

        this.productService=productService;
    }

    @GetMapping()   // localhost:8080/products
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistsException {

        return new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.OK);
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){

//        Product p = new Product();
//
//        p.setTitle("A new Product");

        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){

        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProductDetails(@PathVariable("id") Long id, @RequestBody Product product){

        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }
}
