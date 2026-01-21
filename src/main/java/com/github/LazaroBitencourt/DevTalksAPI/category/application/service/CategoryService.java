package com.github.LazaroBitencourt.DevTalksAPI.category.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryRequest;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryRespose;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.ListCategoryResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryIdResponse createNewCategory(CategoryRequest categoryRequest);

    CategoryRespose findCategoryById(UUID idCategory);

    List<ListCategoryResponse> listCategories();

    void updateCategory(CategoryRequest categoryRequest, UUID idCategory);

    void deactivateCategory(UUID idCategory);

    void activateCategory(UUID idCategory);

    void deleteCategory(UUID idCategory);

    void uploadImageCategory(UUID idCategory, MultipartFile image);
}
