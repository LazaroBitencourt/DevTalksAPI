package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/users")
public interface UserAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserIdResponse postCreateNewUser(@RequestBody @Valid UserRequest userRequest,HttpServletResponse uri);

    @GetMapping("/{idUser}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserDetailsResponse getFindUserDetails(@PathVariable("idUser") UUID idUser);

    @PatchMapping("/{idUser}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void patchUpdateUserInformation(@PathVariable("idUser") UUID idUser, @RequestBody UserUpdateRequest userUpdateRequest);

    @PatchMapping("/{idUser}/DEACTIVATE")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void patchDeactivateUser(@PathVariable("idUser") UUID idUser);

    @PatchMapping("/{idUser}/ACTIVE")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void patchActivateUser(@PathVariable("idUser") UUID idUser);

    @DeleteMapping("/{idUser}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("idUser") UUID idUser);

    @PostMapping("/{idUser}/upload")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void postUploadImageUser(@PathVariable("idUser") UUID idUser,@RequestParam("file") MultipartFile file);

    @GetMapping("/download/{fileName:.+}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Resource> getDownloadImageUser(@PathVariable("fileName") String fileName , HttpServletRequest request);
}
