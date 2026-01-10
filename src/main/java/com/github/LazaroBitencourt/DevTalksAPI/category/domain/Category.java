package com.github.LazaroBitencourt.DevTalksAPI.category.domain;

import jakarta.validation.constraints.Email;

import java.util.UUID;

@Email
public class Category {
    UUID idCategory;
}
