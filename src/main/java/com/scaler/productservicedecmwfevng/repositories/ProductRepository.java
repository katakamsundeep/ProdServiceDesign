package com.scaler.productservicedecmwfevng.repositories;

import com.scaler.productservicedecmwfevng.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends
        JpaRepository<Product,Long> {

    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    Product save(Product product);


    void deleteById(Long id);
}
