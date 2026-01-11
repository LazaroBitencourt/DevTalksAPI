package com.github.LazaroBitencourt.DevTalksAPI.category.infra;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.repository.CategoryRepository;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.service.CategoryService;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;
import com.github.LazaroBitencourt.DevTalksAPI.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CategoryInfraRepository implements CategoryRepository {
    private final CategorySpringDataJpaRepository jpaRepository;

    @Override
    public Category save(Category category) {
        log.info("[start] CategoryApplicationService - save");
        try{
            jpaRepository.save(category);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST,"THERE ARE DUPLICATE DATA", e);
        }

        log.info("[finish] CategoryInfraRepository - save");
        return category;
    }
}
