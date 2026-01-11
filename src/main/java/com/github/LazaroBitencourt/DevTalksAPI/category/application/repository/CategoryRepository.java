package com.github.LazaroBitencourt.DevTalksAPI.category.application.repository;

import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;

public interface CategoryRepository {
    Category save(Category category);
}
