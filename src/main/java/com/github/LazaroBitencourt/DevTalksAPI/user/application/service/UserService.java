package com.github.LazaroBitencourt.DevTalksAPI.user.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserDetailsResponse;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserRequest;

import java.util.UUID;

public interface UserService {
    UserIdResponse createNewUser(UserRequest userRequest);

    UserDetailsResponse findUserDetails(UUID idUser);
}
