package com.github.LazaroBitencourt.DevTalksAPI.post.domain;
import com.github.LazaroBitencourt.DevTalksAPI.author.domain.Author;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "tb_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", name = "post_id", unique = true, nullable = false)
    UUID idPost;
    String title;
    String content;
    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    byte[] image;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    Author author;
    @OneToOne
    @JoinColumn(name = "category_id", nullable = false, updatable = false)
    Category category;
    @Column(name = "created_at")
    private LocalDateTime createAt;
    @Column(name = "updateAt")
    private LocalDateTime updateAt;
    @Enumerated(EnumType.STRING)
    Status status;
}
