package com.hexagonal.demo.application.service;

import com.hexagonal.demo.application.ports.input.CategoryUseCase;
import com.hexagonal.demo.application.ports.output.CategoryOutputPort;
import com.hexagonal.demo.domain.Category;

import java.util.List;
import java.util.Optional;

public class CategoryService implements CategoryUseCase {

    private final CategoryOutputPort categoryOutputPort;

    public CategoryService(CategoryOutputPort categoryOutputPort) {
        this.categoryOutputPort = categoryOutputPort;
    }

    @Override
    public Optional<Category> findById(Long categoryId) {
        return categoryOutputPort.findById(categoryId);
    }

    @Override
    public Category findBy(Long categoryId) {
        return categoryOutputPort.findBy(categoryId);
    }

    @Override
    public List<Category> findByParentId(Long parentId) {
        return categoryOutputPort.findByParentId(parentId);
    }
}
