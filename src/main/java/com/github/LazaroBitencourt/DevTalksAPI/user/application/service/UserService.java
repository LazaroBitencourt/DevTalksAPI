package com.github.LazaroBitencourt.DevTalksAPI.user.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserDetailsResponse;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserRequest;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserUpdateRequest;

import java.util.UUID;

public interface UserService {
    UserIdResponse createNewUser(UserRequest userRequest);

    UserDetailsResponse findUserDetails(UUID idUser);

    void UpdateUserInformation(UUID idUser, UserUpdateRequest userUpdateRequest);

    void deactivateUser(UUID idUser);
}
