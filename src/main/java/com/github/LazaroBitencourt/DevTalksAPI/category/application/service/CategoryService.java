package com.github.LazaroBitencourt.DevTalksAPI.category.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryRequest;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryRespose;

import java.util.UUID;

public interface CategoryService {
    CategoryIdResponse createNewCategory(CategoryRequest categoryRequest);

    CategoryRespose findCategoryById(UUID idCategory);
}
