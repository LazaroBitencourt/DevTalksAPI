package com.github.LazaroBitencourt.DevTalksAPI.user.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserDetailsResponse;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserRequest;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.repository.UserRepository;
import com.github.LazaroBitencourt.DevTalksAPI.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserApplicationservice implements UserService{
    private final UserRepository repository;
    @Override
    public UserIdResponse createNewUser(UserRequest userRequest) {
        log.info("[start] UserApplicationservice - createNewUser");
        User user = repository.save(new User((userRequest)));
        log.info("[finish] UserApplicationservice - createNewUser");
        return UserIdResponse.builder().idUser(user.getId()).build();
    }

    @Override
    public UserDetailsResponse findUserDetails(UUID idUser) {
        log.info("[start] UserApplicationservice - findUserDetails");
        User user = repository.findUserById(idUser);
        log.info("[finish] UserApplicationservice - findUserDetails");
        return new UserDetailsResponse(user);
    }
}
