package com.github.LazaroBitencourt.DevTalksAPI.author.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", name = "author_id", unique = true, nullable = false)
    UUID idAuthor;
}
