package com.github.LazaroBitencourt.DevTalksAPI.category.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", name = "category_id", unique = true, nullable = false)
    UUID idCategory;
}
