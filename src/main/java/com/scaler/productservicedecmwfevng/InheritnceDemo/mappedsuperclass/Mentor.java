package com.scaler.productservicedecmwfevng.InheritnceDemo.mappedsuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_mentor")
public class Mentor extends User {
//    private Long id;

    private double averageRating;
}