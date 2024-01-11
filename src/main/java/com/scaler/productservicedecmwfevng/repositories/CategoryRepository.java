package com.scaler.productservicedecmwfevng.repositories;

import com.scaler.productservicedecmwfevng.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
