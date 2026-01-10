package com.github.LazaroBitencourt.DevTalksAPI.user.domain;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserRequest;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.api.UserUpdateRequest;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_user")
@SQLDelete(sql = "UPDATE tb_user SET status = 'DELETED' WHERE id_user = ?")
@SQLRestriction(value = "status <> 'DELETED'")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", name = "user_id", unique = true, nullable = false)
    private UUID id;
    private String name;
    private String  userName;
    private String email;
    private String password;
    @Column(length = 500)
    private String bio;
    @Lob
    @Column(name = "photo", columnDefinition = "BLOB")
    private byte[] photo;
    private Integer reputation;
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status userStatus;
    @Column(name = "created_at")
    private LocalDateTime createAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    public User(UserRequest userRequest){
        this.name = userRequest.name();
        this.userName = userRequest.userName();
        this.email = userRequest.email();
        this.password = userRequest.password();
        this.bio = userRequest.bio();
        this.photo = userRequest.photo();
        this.userStatus = Status.ACTIVE;
        this.createAt = LocalDateTime.now();
    }

    public void updateUserInformation(UserUpdateRequest userUpdateRequest) {
        userUpdateRequest.name().ifPresent(value -> this.name = value);
        userUpdateRequest.userName().ifPresent(value -> this.userName = value);
        userUpdateRequest.email().ifPresent(value -> this.email = value);
        userUpdateRequest.password().ifPresent(value -> this.password = value);
        userUpdateRequest.bio().ifPresent(value -> this.bio = value);
        userUpdateRequest.photo().ifPresent(value -> this.photo = value);
        this.updateAt = LocalDateTime.now();
    }

    public void changeUserStatusToDeactivated() {
        this.userStatus = Status.DEACTIVATE;
    }

    public void changeUserStatusToActive() {
        this.userStatus = Status.ACTIVE;
    }

    public void changeUserStatusToDeleted() {
        this.userStatus = Status.DELETED;
    }
}

