package com.github.LazaroBitencourt.DevTalksAPI.post.application.api;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PostIdResponse(
        UUID idPost
) {

}
