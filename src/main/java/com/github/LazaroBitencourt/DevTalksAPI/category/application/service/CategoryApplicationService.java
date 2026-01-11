package com.github.LazaroBitencourt.DevTalksAPI.category.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryApplicationService implements CategoryService{
    @Override
    public CategoryIdResponse createNewCatergory(CategoryRequest categoryRequest) {
        return null;
    }
}
