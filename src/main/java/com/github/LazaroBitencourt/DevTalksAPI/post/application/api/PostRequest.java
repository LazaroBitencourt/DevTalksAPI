package com.github.LazaroBitencourt.DevTalksAPI.post.application.api;

import java.util.UUID;

public record PostRequest(
        String title,
        String content,
        UUID idAuthor,
        UUID  idCategory
) {
}
