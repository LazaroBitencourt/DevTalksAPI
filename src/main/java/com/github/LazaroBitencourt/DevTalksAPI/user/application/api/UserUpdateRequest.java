package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.user.domain.Status;

import java.util.Optional;

public record UserUpdateRequest (
    Optional<String> name,
    Optional<String> userName,
    Optional<String>email,
    Optional<String> password,
    Optional<String> bio,
    Optional<Byte[]> photo,
    Optional<Integer> reputation,
    Optional<Status> userStatus
){}
