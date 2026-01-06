package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;

public record UserRequest(
        String name,
        String userName,
        String email,
        String password,
        String bio,
        Byte[] photo,
        Integer reputation
) {

}
