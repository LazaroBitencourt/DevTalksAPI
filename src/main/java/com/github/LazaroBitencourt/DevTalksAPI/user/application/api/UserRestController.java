package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.user.application.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserRestController implements UserAPI{
    private final UserService userService;

    @Override
    public UserIdResponse postCreateNewUser(UserRequest userRequest, HttpServletResponse response) {
        log.info("[start] UserRestController - postCreateNewUser");
        UserIdResponse user = userService.createNewUser(userRequest);
        String uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.idUser())
                .toUriString();
        response.setHeader("Location", uri);
        log.info("[finish] UserRestController - postCreateNewUser");
        return user;
    }

    @Override
    public UserDetailsResponse getFindUserDetails(UUID idUser) {
        log.info("[start] UserRestController - getFindUserDetails");
        UserDetailsResponse user = userService.findUserDetails(idUser);
        log.info("[finish] UserRestController - getFindUserDetails");
        return user;
    }

    @Override
    public void patchUpdateUserInformation(UUID idUser, UserUpdateRequest userUpdateRequest) {
        log.info("[start] UserRestController - patchUpdateUserInformation");
        userService.updateUserInformation(idUser,userUpdateRequest);
        log.info("[finish] UserRestController - patchUpdateUserInformation");
    }

    @Override
    public void patchDeactivateUser(UUID idUser) {
        log.info("[start] UserRestController - patchDeactivateUser");
        userService.deactivateUser(idUser);
        log.info("[finish] UserRestController - patchDeactivateUser");
    }

    @Override
    public void patchActivateUser(UUID idUser) {
        log.info("[start] UserRestController - patchActivateUser");
        userService.activateUser(idUser);
        log.info("[finish] UserRestController - patchActivateUser");
    }

    @Override
    public void deleteUser(UUID idUser) {
        log.info("[start] UserRestController - deleteUser");
        userService.deleteUserById(idUser);
        log.info("[finish] UserRestController - deleteUser");
    }
}
