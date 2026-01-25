package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank(message = "NAME CANNOT BE NULL OR EMPTY")
        @Size(max = 100, message = "NAME MUST BE AT MOST 100 CHARACTERS")
        String name,
        @NotBlank(message = "DESCRIPTION CANNOT BE NULL OR EMPTY")
        @Size(max = 255, message = "DESCRIPTION MUST BE AT MOST 255 CHARACTERS")
        String description
) {
}
