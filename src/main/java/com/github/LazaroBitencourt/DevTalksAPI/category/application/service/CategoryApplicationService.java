package com.github.LazaroBitencourt.DevTalksAPI.category.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CategoryApplicationService implements CategoryService{

    @Override
    public CategoryIdResponse createNewCategory(CategoryRequest categoryRequest) {
        log.info("[start] CategoryApplicationService - createNewCategory");

        log.info("[finish] CategoryApplicationService - createNewCategory");
        return null;
    }
}
