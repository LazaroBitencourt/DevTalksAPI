package com.github.LazaroBitencourt.DevTalksAPI.category.infra;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.repository.CategoryRepository;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
public class CategoryInfraRepository implements CategoryRepository {
    @Override
    public Category save(Category category) {
        return null;
    }
}
