package com.scaler.productservicedecmwfevng.controller;

import com.scaler.productservicedecmwfevng.commons.AuthenticationCommons;
import com.scaler.productservicedecmwfevng.dtos.Role;
import com.scaler.productservicedecmwfevng.dtos.UserDto;
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

    private AuthenticationCommons authenticationCommons;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService,
                                AuthenticationCommons authenticationCommons){

        this.productService=productService;
        this.authenticationCommons = authenticationCommons;
    }

    @GetMapping()   // localhost:8080/products
    public ResponseEntity<List<Product>> getAllProducts(@RequestHeader String token){

        UserDto userDto = authenticationCommons.validateToken(token);
       if( userDto == null){

           return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
       }

       boolean isAdmin = false;

       for(Role role : userDto.getRoles()){
           if(role.getName().equals("Admin")){
               isAdmin = true;
               break;
           }
       }

       if(!isAdmin){
           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
       }
        List<Product> productList = productService.getAllProducts();

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


        ResponseEntity<List<Product>> response = new ResponseEntity<>(productList, HttpStatus.FORBIDDEN);



        return response;
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

        return productService.updateProduct(id,product);
    }

    @PutMapping("/{id}")
    public Product replaceProductDetails(@PathVariable("id") Long id, @RequestBody Product product){

        return productService.replaceProduct(id,product );
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotExistsException {

         productService.deleteProduct(id);
    }
}
