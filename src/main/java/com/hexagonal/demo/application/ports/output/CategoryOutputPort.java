package com.hexagonal.demo.application.ports.output;

import com.hexagonal.demo.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryOutputPort {

    Optional<Category> findById(Long categoryId);

    Category findBy(Long categoryId);

    List<Category> findByParentId(Long parentId);
}
