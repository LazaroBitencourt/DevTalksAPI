package com.github.LazaroBitencourt.DevTalksAPI.category.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryRequest;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.CategoryRespose;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.api.ListCategoryResponse;
import com.github.LazaroBitencourt.DevTalksAPI.category.application.repository.CategoryRepository;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;
import com.github.LazaroBitencourt.DevTalksAPI.util.Upload;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class CategoryApplicationService implements CategoryService {

    @Value("${server.servlet.context-path}")
    private String contextPathApi;
    private final CategoryRepository categoryRepository;
    private final Upload upload;

    @Override
    public CategoryIdResponse createNewCategory(CategoryRequest categoryRequest) {
        log.info("[start] CategoryApplicationService - createNewCategory");
        Category category = categoryRepository.save(new Category(categoryRequest));
        log.info("[finish] CategoryApplicationService - createNewCategory");
        return CategoryIdResponse.builder().idCategory(category.getIdCategory()).build();
    }

    @Override
    public CategoryRespose findCategoryById(UUID idCategory) {
        log.info("[start] CategoryApplicationService - findCategoryById(");
        Category category = categoryRepository.findCategoryById(idCategory);
        log.info("[finish] CategoryApplicationService - findCategoryById(");
        return new CategoryRespose(category);
    }

    @Override
    public List<ListCategoryResponse> listCategories() {
        log.info("[start] CategoryApplicationService - listCategories");
        List<Category> listCategory = categoryRepository.findAllCategory();
        log.info("[finish] CategoryApplicationService - listCategories");
        return ListCategoryResponse.convertToListOfCategoryResponse(listCategory);

    }

    @Override
    public void updateCategory(CategoryRequest categoryRequest, UUID idCategory) {
        log.info("[start] CategoryApplicationService - updateCategory]");
        Category category = categoryRepository.findCategoryById(idCategory);
        category.updateCategory(categoryRequest);
        categoryRepository.save(category);
        log.info("[finish] CategoryApplicationService - updateCategory]");
    }

    @Override
    public void deactivateCategory(UUID idCategory) {
        log.info("[start] CategoryApplicationService - deactivateCategory");
        Category category = categoryRepository.findCategoryById(idCategory);
        category.changeCategoryStatusToDeactivated();
        categoryRepository.save(category);
        log.info("[finish] CategoryApplicationService - deactivateCategory");
    }

    @Override
    public void activateCategory(UUID idCategory) {
        log.info("[start] CategoryApplicationService - activateCategory");
        Category category = categoryRepository.findCategoryById(idCategory);
        category.changeCategoryStatusToActive();
        categoryRepository.save(category);
        log.info("[finish] CategoryApplicationService - activateCategory");
    }

    @Override
    public void deleteCategory(UUID idCategory) {
        log.info("[start] CategoryApplicationService - deleleCategory");
        Category category = categoryRepository.findCategoryById(idCategory);
        category.changeCategoryStatusToDeleted();
        categoryRepository.save(category);
        log.info("[finish] CategoryApplicationService - deleleCategory");
    }

    @Override
    public void uploadImageCategory(UUID idCategory, MultipartFile image) {
        log.info("[start] CategoryApplicationService - uploadImageCategory");
        Category category = categoryRepository.findCategoryById(idCategory);
        String directoryNameToCategory = "Category_Images";
        String imageNameSaved = upload.uploadFile(image, category.getIdCategory(), directoryNameToCategory);
        String imageCategoryUri = contextPathApi
                + "/category/download"
                + "/"
                + imageNameSaved;
        category.addImageUri(imageCategoryUri);
        categoryRepository.save(category);
        log.info("[finish] CategoryApplicationService - uploadImageCategory");
    }
}
