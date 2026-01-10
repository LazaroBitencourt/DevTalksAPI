package com.github.LazaroBitencourt.DevTalksAPI.post.domain;
import com.github.LazaroBitencourt.DevTalksAPI.author.domain.Author;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    UUID idPost;
    String title;
    String content;
    Byte[] image;
    Author author;
    Category category;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Status status;
}
