package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Status;

import java.util.UUID;

public record ListCategoryResponse(
        UUID idCategory,
        String name,
        String description,
        byte[] image,
        Status status
) {
}
