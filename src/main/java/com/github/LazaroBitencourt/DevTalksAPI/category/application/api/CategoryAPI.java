package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/category")
public interface CategoryAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryIdResponse postCreateNewCategory(@RequestBody CategoryRequest categoryRequest, HttpServletResponse response);

    @GetMapping("/{idCategory}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryRespose getFindCategoryById(@PathVariable("idCategory") UUID idCategory);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ListCategoryResponse> getListCategories();

    @PatchMapping("/{idCategory}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void patchUpdateCategory(@RequestBody CategoryRequest categoryRequest, @PathVariable("idCategory") UUID idCategory);

    @PatchMapping("/{idCategory}/DEACTIVATE")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void patchDeactivateCategory(@PathVariable("idCategory") UUID idCategory);

    @PatchMapping("/{idCategory}/ACTIVE")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void patchActivateCategory(@PathVariable("idCategory") UUID idCategory);

    @DeleteMapping("/{idCategory}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleleCategory(@PathVariable("idCategory") UUID idCategory);
}
