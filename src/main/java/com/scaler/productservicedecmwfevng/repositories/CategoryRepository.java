package com.scaler.productservicedecmwfevng.repositories;

import com.scaler.productservicedecmwfevng.models.Category;
import com.scaler.productservicedecmwfevng.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    @Override
    List<Category> findAll();
    Optional<Category> findByName(String name);

    Optional<Category> findById(Long id);
}
