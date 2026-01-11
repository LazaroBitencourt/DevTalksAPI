package com.github.LazaroBitencourt.DevTalksAPI.category.application.repository;

import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;

import java.util.UUID;

public interface CategoryRepository {
    Category save(Category category);

    Category findCategoryById(UUID idCategory);
}
