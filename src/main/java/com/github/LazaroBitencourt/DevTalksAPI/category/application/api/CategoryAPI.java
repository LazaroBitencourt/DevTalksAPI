package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/category")
public interface CategoryAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryIdResponse postCreateNewCategory(@RequestBody CategoryRequest categoryRequest);

    @GetMapping("/{idCategory}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryRespose getFindCategoryById(@PathVariable("idCategory")UUID idCategory);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ListCategoryResponse> getListCategories();
}
