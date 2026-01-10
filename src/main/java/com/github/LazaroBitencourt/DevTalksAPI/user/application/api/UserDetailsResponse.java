package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.user.domain.Status;
import com.github.LazaroBitencourt.DevTalksAPI.user.domain.User;

public record UserDetailsResponse(
        String name,
        String userName,
        String bio,
        byte[] photo,
        Integer reputation,
        Status userStatus
) {
    public UserDetailsResponse(User user){
        this (
                user.getName(),
                user.getUserName(),
                user.getBio(),
                user.getPhoto(),
                user.getReputation(),
                user.getUserStatus());
    }
}
