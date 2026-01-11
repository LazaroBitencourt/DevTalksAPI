package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Status;
import com.github.LazaroBitencourt.DevTalksAPI.post.domain.Post;

import java.util.List;
import java.util.UUID;

public record CategoryRespose(
        UUID idCategory,
        String name,
        String description,
        byte[] image,
        Status status,
        List<Post> posts
) {
    public CategoryRespose(Category category) {
        this(
                category.getIdCategory(),
                category.getName(),
                category.getDescription(),
                category.getImage(),
                category.getStatus(),
                category.getPosts()
        );
    }
}
