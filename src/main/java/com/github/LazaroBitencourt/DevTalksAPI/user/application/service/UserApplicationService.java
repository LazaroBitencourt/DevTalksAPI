package com.github.LazaroBitencourt.DevTalksAPI.user.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserDetailsResponse;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserRequest;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserUpdateRequest;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.repository.UserRepository;
import com.github.LazaroBitencourt.DevTalksAPI.user.domain.User;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserApplicationService implements UserService{
    private final UserRepository repository;
    @Override
    @Transactional
    public UserIdResponse createNewUser(UserRequest userRequest) {
        log.info("[start] UserApplicationService - createNewUser");
        User user = repository.save(new User((userRequest)));
        log.info("[finish] UserApplicationService - createNewUser");
        return UserIdResponse.builder().idUser(user.getId()).build();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetailsResponse findUserDetails(UUID idUser) {
        log.info("[start] UserApplicationService - findUserDetails");
        User user = repository.findUserById(idUser);
        log.info("[finish] UserApplicationService - findUserDetails");
        return new UserDetailsResponse(user);
    }

    @Override
    @Transactional
    public void updateUserInformation(UUID idUser, UserUpdateRequest userUpdateRequest) {
        log.info("[start] UserApplicationService - UpdateUserInformation");
        User user = repository.findUserById(idUser);
        user.updateUserInformation(userUpdateRequest);
        repository.save(user);
        log.info("[finish] UserApplicationService - UpdateUserInformation");
    }

    @Override
    @Transactional
    public void deactivateUser(UUID idUser) {
        log.info("[start] UserApplicationService - deactivateUser");
        User user = repository.findUserById(idUser);
        user.changeUserStatusToDeactivated();
        repository.save(user);
        log.info("[finish] UserApplicationService - deactivateUser");
    }

    @Override
    @Transactional
    public void activateUser(UUID idUser) {
        log.info("[start] UserApplicationService - activateUser");
        User user = repository.findUserById(idUser);
        user.changeUserStatusToActive();
        repository.save(user);
        log.info("[finish] UserApplicationService - activateUser");
    }

    @Override
    @Transactional
    public void deleteUserById(UUID idUser) {
    log.info("[start] UserApplicationService - deleteUserById");
        User user = repository.findUserById(idUser);
        user.changeUserStatusToDeleted();
        repository.save(user);
    log.info("[finish] UserApplicationService - deleteUserById");
    }
}
