package com.scaler.productservicedecmwfevng.services;

import com.scaler.productservicedecmwfevng.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfevng.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotExistsException;


    List<Product> getAllProducts();

    Product addNewProduct(Product product);

    Product replaceProduct(Long id, Product product);

    Product deleteProduct(Long id) throws ProductNotExistsException;

    Product updateProduct (Long id, Product product);
}
