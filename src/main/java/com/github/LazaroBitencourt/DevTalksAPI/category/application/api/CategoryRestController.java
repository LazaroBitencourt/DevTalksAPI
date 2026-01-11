package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CategoryRestController implements CategoryAPI{

    private  final CategoryService categoryService;
    @Override
    public CategoryIdResponse postCreateNewCategory(CategoryRequest categoryRequest) {
        log.info("[start] CategoryRestController - postCreateCategory");
        CategoryIdResponse category = categoryService.createNewCategory(categoryRequest);
        log.info("[finish] CategoryRestController - postCreateCategory");
        return category;
    }
}
