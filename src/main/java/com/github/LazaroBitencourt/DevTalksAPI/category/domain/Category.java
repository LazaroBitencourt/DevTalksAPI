package com.github.LazaroBitencourt.DevTalksAPI.category.domain;

import com.github.LazaroBitencourt.DevTalksAPI.post.domain.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @OneToMany(mappedBy = "category")
    List<Post> posts;
}
