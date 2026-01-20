package com.github.LazaroBitencourt.DevTalksAPI.category.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.service.CategoryService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CategoryRestController implements CategoryAPI{

    private  final CategoryService categoryService;
    @Override
    public CategoryIdResponse postCreateNewCategory(CategoryRequest categoryRequest, HttpServletResponse response) {
        log.info("[start] CategoryRestController - postCreateCategory");
        CategoryIdResponse category = categoryService.createNewCategory(categoryRequest);
        String uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.idCategory())
                .toUriString();
        response.setHeader("Location", uri);
        log.info("[finish] CategoryRestController - postCreateCategory");
        return category;
    }

    @Override
    public CategoryRespose getFindCategoryById(UUID idCategory) {
        log.info("[start] CategoryRestController - getFindCategoryById");
        CategoryRespose category = categoryService.findCategoryById(idCategory);
        log.info("[finish] CategoryRestController - getFindCategoryById");
        return category;
    }

    @Override
    public List<ListCategoryResponse> getListCategories() {
        log.info("[start] CategoryRestController - getListCategories");
        List<ListCategoryResponse> listCategories = categoryService.listCategories();
        log.info("[finish] CategoryRestController - getListCategories");
        return listCategories;
    }

    @Override
    public void patchUpdateCategory(CategoryRequest categoryRequest, UUID idCategory) {
        log.info("[start] CategoryRestController - patchUpdateCategory");
        categoryService.updateCategory(categoryRequest,idCategory);
        log.info("[finish] CategoryRestController - patchUpdateCategory");
    }

    @Override
    public void patchDeactivateCategory(UUID idCategory) {
        log.info("[start] CategoryRestController - patchDeactivateCategory");
        categoryService.deactivateCategory(idCategory);
        log.info("[finish] CategoryRestController - patchDeactivateCategory");
    }

    @Override
    public void patchActivateCategory(UUID idCategory) {
        log.info("[start] CategoryRestController - patchActivateCategory");
        categoryService.activateCategory(idCategory);
        log.info("[finish] CategoryRestController - patchActivateCategory");
    }

    @Override
    public void deleleCategory(UUID idCategory) {
        log.info("[start] CategoryRestController - deleleCategory");
        categoryService.deleteCategory(idCategory);
        log.info("[finish] CategoryRestController - deleleCategory");
    }

    @Override
    public void postUploadImageCategory(UUID idCategory, MultipartFile image) {
    log.info("[start] CategoryRestController - postUploadImageCategory");

    log.info("[finish] CategoryRestController - postUploadImageCategory");
    }
}
