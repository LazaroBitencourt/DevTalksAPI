package com.github.LazaroBitencourt.DevTalksAPI.category.infra;

import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategorySpringDataJpaRepository extends JpaRepository<Category, UUID> {
}
