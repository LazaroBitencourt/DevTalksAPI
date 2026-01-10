package com.github.LazaroBitencourt.DevTalksAPI.author.domain;

import jakarta.validation.constraints.Email;

import java.util.UUID;

@Email
public class Author {
    UUID idAuthor;
}
