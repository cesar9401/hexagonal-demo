package com.hexagonal.demo.application.ports.input;

import com.hexagonal.demo.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryUseCase {

    Optional<Category> findById(Long categoryId);

    Category findBy(Long categoryId);

    List<Category> findByParentId(Long parentId);
}
