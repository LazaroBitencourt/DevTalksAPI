package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;
import com.github.LazaroBitencourt.DevTalksAPI.user.domain.Status;

public record UserRequest(
        String name,
        String userName,
        String email,
        String password,
        String bio,
        byte[] photo,
        int reputation,
        Status userStatus
) {

}
