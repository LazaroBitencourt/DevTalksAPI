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
}
