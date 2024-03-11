package com.scaler.productservicedecmwfevng.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

//    @OneToMany(mappedBy = "category")
//    @JsonManagedReference
//    private List<Product> productList;
    private String name;


}
