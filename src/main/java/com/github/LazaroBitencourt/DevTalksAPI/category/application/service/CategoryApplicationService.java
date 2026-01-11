package com.github.LazaroBitencourt.DevTalksAPI.category.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryRequest;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.repository.CategoryRepository;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CategoryApplicationService implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryIdResponse createNewCategory(CategoryRequest categoryRequest) {
        log.info("[start] CategoryApplicationService - createNewCategory");
        Category category = categoryRepository.save(new Category(categoryRequest));
        log.info("[finish] CategoryApplicationService - createNewCategory");
        return CategoryIdResponse.builder().idCategory(category.getIdCategory()).build();
    }
}
