package com.github.LazaroBitencourt.DevTalksAPI.user.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank(message = "NAME CANNOT BE NULL OR EMPTY")
        @Size(max = 100, message = "NAME MUST BE AT MOST 100 CHARACTERS")
        String name,

        @NotBlank(message = "USERNAME CANNOT BE NULL OR EMPTY")
        @Size(min = 3, max = 50, message = "USERNAME MUST BE BETWEEN 3 AND 50 CHARACTERS")
        String userName,

        @Email(message = "PLEASE ENTER A VALID EMAIL ADDRESS")
        @NotBlank(message = "EMAIL CANNOT BE NULL OR EMPTY")
        @Size(max = 150, message = "EMAIL MUST BE AT MOST 150 CHARACTERS")
        String email,

        @NotBlank(message = "PASSWORD CANNOT BE NULL OR EMPTY")
        @Size(min = 8, message = "PASSWORD MUST BE AT LEAST 8 CHARACTERS")
        String password,

        @Size(max = 500, message = "BIO MUST BE AT MOST 500 CHARACTERS")
        String bio,
        byte[] photo
) {

}
