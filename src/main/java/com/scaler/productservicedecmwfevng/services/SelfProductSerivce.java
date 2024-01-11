package com.scaler.productservicedecmwfevng.services;

import com.scaler.productservicedecmwfevng.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfevng.models.Product;
import com.scaler.productservicedecmwfevng.repositories.CategoryRepository;
import com.scaler.productservicedecmwfevng.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductSerivce implements ProductService{

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public SelfProductSerivce(ProductRepository productRepository,
                              CategoryRepository categoryRepository){

        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) throws ProductNotExistsException {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
}
