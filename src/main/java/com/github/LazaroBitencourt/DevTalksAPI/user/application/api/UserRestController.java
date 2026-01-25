package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.user.application.service.UserService;
import com.github.LazaroBitencourt.DevTalksAPI.util.download.Download;
import com.github.LazaroBitencourt.DevTalksAPI.util.fileResponse.FileResponseUtil;
import com.github.LazaroBitencourt.DevTalksAPI.util.fileValidate.ImageValidation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserRestController implements UserAPI {

    @Value("${path.upload.directory.users}")
    private String userDirectory;

    private final UserService userService;
    private final ImageValidation imageValidation;
    private final Download download;
    private final FileResponseUtil fileResponse;

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
        userService.updateUserInformation(idUser, userUpdateRequest);
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

    @Override
    public void postUploadImageUser(UUID idUser, MultipartFile file) {
        log.info("[start] UserRestController - postUploadImageUser");
        imageValidation.validate(file);
        userService.uploadImageUser(idUser, file);
        log.info("[finish] UserRestController - postUploadImageUser");
    }

    @Override
    public ResponseEntity<Resource> getDownloadImageUser(String fileName, HttpServletRequest request) {
        log.info("[start] UserRestController - getDownloadImageUser");
        Resource resource = download.downloadFile(userDirectory, fileName);
        String contentType = fileResponse.getContentType(request, resource);
        String headerValue = fileResponse.getHeaderValue(resource);
        log.info("[finish] UserRestController - getDownloadImageUser");
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
}
