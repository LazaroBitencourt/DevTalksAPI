package com.github.LazaroBitencourt.DevTalksAPI.category.domain;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryRequest;
import com.github.LazaroBitencourt.DevTalksAPI.post.domain.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", name = "category_id", unique = true, nullable = false)
    UUID idCategory;
    String name;
    String description;
    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    byte[] image;
    @Enumerated(EnumType.STRING)
    Status status;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    List<Post> posts;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Category(CategoryRequest categoryRequest) {
        this.name = categoryRequest.name();
        this.description = categoryRequest.description();
        this.status = Status.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    public void updateCategory(CategoryRequest categoryRequest) {
        this.name = categoryRequest.name();
        this.description = categoryRequest.description();
    }

    public void changeCategoryStatusToDeactivated() {
        this.status = Status.DEACTIVATED;
    }
}
