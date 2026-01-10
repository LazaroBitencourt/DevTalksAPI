package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/category")
public interface CategoryAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryIdResponse postCreateCategory(@RequestBody CategoryRequest categoryRequest);
}
