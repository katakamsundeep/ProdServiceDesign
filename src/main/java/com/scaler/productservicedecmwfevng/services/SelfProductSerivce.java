package com.scaler.productservicedecmwfevng.services;

import com.scaler.productservicedecmwfevng.exception.ProductNotExistsException;
import com.scaler.productservicedecmwfevng.models.Category;
import com.scaler.productservicedecmwfevng.models.Product;
import com.scaler.productservicedecmwfevng.repositories.CategoryRepository;
import com.scaler.productservicedecmwfevng.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()){
            throw new ProductNotExistsException("Product id with "+id +" doesnt exist");
        }

            Product product = productOptional.get();


        return product;
    }

    @Override
    public List<Product> getAllProducts()  {

        List<Product> productList = new ArrayList<>();

        productList = productRepository.findAll();

        if(!productList.isEmpty()) {

            return productList;
        }
        for (Product product : productList) {
            productList.add(product);
        }
        return productList;
    }

    @Override
    public Product addNewProduct(Product product) {

        //created by using findbyid from categoryrepo
       /* Optional<Category> categoryOptional=categoryRepository.findById(product.getCategory().getId());

        if(categoryOptional.isEmpty()){
           product.setCategory(categoryRepository.save(product.getCategory()));
        }else{
            product.setCategory(categoryOptional.get());
        }*/

        //crated by using findbyname from categoryrepo
        Optional<Category> categoryOptional= categoryRepository.findByName(product.getCategory().getName());

        if(categoryOptional.isEmpty()){
            product.setCategory(categoryRepository.save(product.getCategory()));
        }else{
            product.setCategory(categoryOptional.get());
        }

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {

        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()) throw new RuntimeException();

        Product updateProduct = productOptional.get();


        if(product.getTitle() != null){
            updateProduct.setTitle(product.getTitle());
        }
        if(product.getPrice() != null){
            updateProduct.setPrice(product.getPrice());
        }
        if(product.getDescription() != null){
            updateProduct.setDescription(product.getDescription());
        }
        if(product.getImageUrl() != null){
            updateProduct.setImageUrl(product.getImageUrl());
        }

//        Optional<Category> categoryOptional= categoryRepository.findById(id);
//
//        if(categoryOptional.isEmpty()){
//            throw new RuntimeException();
//        }
        updateProduct.setCategory(categoryRepository.save(product.getCategory()));




        return productRepository.save(updateProduct);

    }

    @Override
    public void deleteProduct(Long id) throws ProductNotExistsException {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()) throw new RuntimeException();

        productRepository.deleteById(id);

    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Optional<Product> productOptional = productRepository.findById(id);


        if(productOptional.isEmpty()) throw new RuntimeException();

        Product updateProduct = productOptional.get();

        if(product.getTitle() != null){
            updateProduct.setTitle(product.getTitle());
        }
        if(product.getPrice() != null){
            updateProduct.setPrice(product.getPrice());
        }
        if(product.getDescription() != null){
            updateProduct.setDescription(product.getDescription());
        }
        if(product.getImageUrl() != null){
            updateProduct.setImageUrl(product.getImageUrl());
        }

        return productRepository.save(updateProduct);
    }
}
