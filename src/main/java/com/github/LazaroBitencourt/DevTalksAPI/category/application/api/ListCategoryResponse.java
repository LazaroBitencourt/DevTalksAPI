package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Status;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ListCategoryResponse(
        UUID idCategory,
        String name,
        String description,
        String imageUri,
        Status status
) {
    public ListCategoryResponse(Category category) {
        this(
                category.getIdCategory(),
                category.getName(),
                category.getDescription(),
                category.getImageUri(),
                category.getStatus()
        );
    }

    public static List<ListCategoryResponse> convertToListOfCategoryResponse(List<Category> categories) {
        return categories.stream().map(
                        category -> new ListCategoryResponse(category))
                .collect(Collectors
                        .toList());
    }

}
