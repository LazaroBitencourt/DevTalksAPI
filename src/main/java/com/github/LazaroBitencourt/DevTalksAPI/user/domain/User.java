package com.github.LazaroBitencourt.DevTalksAPI.user.domain;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserRequest;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserUpdateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", name = "id_user", unique = true, nullable = false)
    private UUID id;
    private String name;
    private String  userName;
    private String email;
    private String password;
    private String bio;
    @Lob
    @Column(name = "photo", columnDefinition = "BLOB")
    private Byte[] photo;
    private Integer reputation;
    @Enumerated(value = EnumType.STRING)
    private Status userStatus;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public User(UserRequest userRequest){
        this.name = userRequest.name();
        this.userName = userRequest.userName();
        this.email = userRequest.email();
        this.password = userRequest.password();
        this.bio = userRequest.bio();
        this.photo = userRequest.photo();
        this.reputation = userRequest.reputation();
        this.userStatus = userRequest.userStatus();
        this.createAt = LocalDateTime.now();
    }

    public void updateUserInformation(UserUpdateRequest userUpdateRequest) {
        userUpdateRequest.name().ifPresent(value -> this.name = value);
        userUpdateRequest.userName().ifPresent(value -> this.userName = value);
        userUpdateRequest.email().ifPresent(value -> this.email = value);
        userUpdateRequest.password().ifPresent(value -> this.password = value);
        userUpdateRequest.bio().ifPresent(value -> this.bio = value);
        userUpdateRequest.photo().ifPresent(value -> this.photo = value);
        userUpdateRequest.reputation().ifPresent(value -> this.reputation = value);
        userUpdateRequest.userStatus().ifPresent(value -> this.userStatus = value);
        this.updateAt = LocalDateTime.now();
    }


}

