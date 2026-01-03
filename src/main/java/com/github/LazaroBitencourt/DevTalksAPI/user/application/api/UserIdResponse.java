package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserIdResponse(
        UUID idUser
) {
}
