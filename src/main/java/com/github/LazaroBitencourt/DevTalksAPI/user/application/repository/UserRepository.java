package com.github.LazaroBitencourt.DevTalksAPI.user.application.repository;

import com.github.LazaroBitencourt.DevTalksAPI.user.domain.User;

import java.util.UUID;

public interface UserRepository {
    User save(User user);

    User findUserById(UUID idUser);
}
