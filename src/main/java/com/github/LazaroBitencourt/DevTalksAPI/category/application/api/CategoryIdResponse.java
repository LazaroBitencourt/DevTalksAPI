package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CategoryIdResponse(
       UUID idCategory
) {
}
