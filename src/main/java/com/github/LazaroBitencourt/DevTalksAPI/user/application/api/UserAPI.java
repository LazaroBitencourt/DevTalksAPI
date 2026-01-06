package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/v1/user")
public interface UserAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserIdResponse postCreateNewUser(@RequestBody UserRequest userRequest);

    @GetMapping("/{idUser}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserDetailsResponse getFindUserDetails(@PathVariable("idUser") UUID idUser);

    @PatchMapping("/{idUser}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void patchUpdateUserInformation(@PathVariable("idUser") UUID idUser, @RequestBody UserUpdateRequest userUpdateRequest);

    @PatchMapping("/{idUser}/DEACTIVATE")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void patchDeactivateUser(@PathVariable("idUser") UUID idUser);
}
