package com.github.LazaroBitencourt.DevTalksAPI.user.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserDetailsResponse;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserRequest;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserUpdateRequest;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.repository.UserRepository;
import com.github.LazaroBitencourt.DevTalksAPI.user.domain.User;
import com.github.LazaroBitencourt.DevTalksAPI.util.upload.Upload;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserApplicationService implements UserService{

    @Value("${server.servlet.context-path}")
    private String contextPathApi;
    @Value("${path.upload.directory.users}")
    private String directoryNameToUsers;

    private final UserRepository userRepository;
    private final Upload upload;

    @Override
    public UserIdResponse createNewUser(UserRequest userRequest) {
        log.info("[start] UserApplicationService - createNewUser");
        User user = userRepository.save(new User((userRequest)));
        log.info("[finish] UserApplicationService - createNewUser");
        return UserIdResponse.builder().idUser(user.getId()).build();
    }

    @Override
    public UserDetailsResponse findUserDetails(UUID idUser) {
        log.info("[start] UserApplicationService - findUserDetails");
        User user = userRepository.findUserById(idUser);
        log.info("[finish] UserApplicationService - findUserDetails");
        return new UserDetailsResponse(user);
    }

    @Override
    public void updateUserInformation(UUID idUser, UserUpdateRequest userUpdateRequest) {
        log.info("[start] UserApplicationService - UpdateUserInformation");
        User user = userRepository.findUserById(idUser);
        user.updateUserInformation(userUpdateRequest);
        userRepository.save(user);
        log.info("[finish] UserApplicationService - UpdateUserInformation");
    }

    @Override
    public void deactivateUser(UUID idUser) {
        log.info("[start] UserApplicationService - deactivateUser");
        User user = userRepository.findUserById(idUser);
        user.changeUserStatusToDeactivated();
        userRepository.save(user);
        log.info("[finish] UserApplicationService - deactivateUser");
    }

    @Override
    public void activateUser(UUID idUser) {
        log.info("[start] UserApplicationService - activateUser");
        User user = userRepository.findUserById(idUser);
        user.changeUserStatusToActive();
        userRepository.save(user);
        log.info("[finish] UserApplicationService - activateUser");
    }

    @Override
    public void deleteUserById(UUID idUser) {
    log.info("[start] UserApplicationService - deleteUserById");
        User user = userRepository.findUserById(idUser);
        user.changeUserStatusToDeleted();
        userRepository.save(user);
    log.info("[finish] UserApplicationService - deleteUserById");
    }

    @Override
    public void uploadImageUser(UUID idUser, MultipartFile file) {
        log.info("[start] UserApplicationService - uploadImageUser");
        User user = userRepository.findUserById(idUser);
        String imageNameSaved = upload.uploadFile(file, user.getId(), directoryNameToUsers);
        String imageUserUri = contextPathApi
                + "/users/download"
                + "/"
                + imageNameSaved;
        user.addImageUri(imageUserUri);
        log.info("[finish] UserApplicationService - uploadImageUser");
    }
}
