package com.github.LazaroBitencourt.DevTalksAPI.post.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.author.domain.Author;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;


public record PostRequest(
        String title,
        String content,
        Author author,
        Category category
) {
}
