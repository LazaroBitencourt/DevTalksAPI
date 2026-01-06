package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.user.application.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserRestController implements UserAPI{
    private final UserService service;
    @Override
    public UserIdResponse postCreateNewUser(UserRequest userRequest) {
        log.info("[start] UserRestController - postCreateNewUser");
        UserIdResponse user = service.createNewUser(userRequest);
        log.info("[finish] UserRestController - postCreateNewUser");
        return user;
    }

    @Override
    public UserDetailsResponse getFindUserDetails(UUID idUser) {
        log.info("[start] UserRestController - getFindUserDetails");
        UserDetailsResponse user = service.findUserDetails(idUser);
        log.info("[finish] UserRestController - getFindUserDetails");
        return user;
    }

    @Override
    public void patchUpdateUserInformation(UUID idUser, UserUpdateRequest userUpdateRequest) {
        log.info("[start] UserRestController - patchUpdateUserInformation");
        service.UpdateUserInformation(idUser,userUpdateRequest);
        log.info("[finish] UserRestController - patchUpdateUserInformation");
    }

    @Override
    public void patchDeactivateUser(UUID idUser) {
        log.info("[start] UserRestController - patchDeactivateUser");
        service.deactivateUser(idUser);
        log.info("[finish] UserRestController - patchDeactivateUser");
    }

    @Override
    public void patchActivateUser(UUID idUser) {
        log.info("[start] UserRestController - patchActivateUser");
        service.activateUser(idUser);
        log.info("[finish] UserRestController - patchActivateUser");
    }

    @Override
    public void deleteUser(UUID idUser) {
        log.info("[start] UserRestController - deleteUser");
        service.deleteUserById(idUser);
        log.info("[finish] UserRestController - deleteUser");
    }
}
