package com.scaler.productservicedecmwfevng.InheritnceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_instructor")
public class Instructor extends User {
    private String favouriteStudent;
}