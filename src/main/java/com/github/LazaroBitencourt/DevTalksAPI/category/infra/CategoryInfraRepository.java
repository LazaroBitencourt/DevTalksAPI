package com.github.LazaroBitencourt.DevTalksAPI.category.infra;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.repository.CategoryRepository;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.service.CategoryService;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;
import com.github.LazaroBitencourt.DevTalksAPI.handler.APIException;
import com.github.LazaroBitencourt.DevTalksAPI.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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

    @Override
    public Category findCategoryById(UUID idCategory) {
        log.info("[start] CategoryApplicationService - findCategoryById");
        Category category = jpaRepository.findById(idCategory).orElseThrow(()
        -> APIException.build(HttpStatus.NOT_FOUND, "USER NOT FOUND OR DOES NOT EXIST!"
                        + " PLEASE PROVIDE A VALID ID OR CONTACT THE SYSTEM ADMINISTRATOR!"));
        log.info("[finish] CategoryApplicationService - findCategoryById");
        return category;
    }
}
