package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class CategoryRestController implements CategoryAPI{
    @Override
    public CategoryIdResponse postCreateCategory(CategoryRequest categoryRequest) {
        log.info("[start] CategoryRestController - postCreateCategory");

        log.info("[finish] CategoryRestController - postCreateCategory");
        return null;
    }
}
