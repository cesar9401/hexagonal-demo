package com.hexagonal.demo.infrastructure.adapters.output.persistence.adapter;

import com.hexagonal.demo.application.ports.output.CategoryOutputPort;
import com.hexagonal.demo.domain.Category;
import com.hexagonal.demo.infrastructure.adapters.output.persistence.entity.QCategoryEntity;
import com.hexagonal.demo.infrastructure.adapters.output.persistence.mapper.CategoryPersistenceMapper;
import com.hexagonal.demo.infrastructure.adapters.output.persistence.repository.CategoryEntityRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryAdapterPersistence implements CategoryOutputPort {

    private final CategoryEntityRepository entityRepository;
    private final EntityManager em;
    private final CategoryPersistenceMapper mapper;

    public CategoryAdapterPersistence(CategoryEntityRepository entityRepository, EntityManager em, CategoryPersistenceMapper mapper) {
        this.entityRepository = entityRepository;
        this.em = em;
        this.mapper = mapper;
    }

    @Override
    public Optional<Category> findById(Long categoryId) {
        // return entityRepository.findById(categoryId)

        var _category = new QCategoryEntity("_category");
        var queryFactory = new JPAQueryFactory(em);

        var categoryEntity = queryFactory
                .selectFrom(_category)
                .where(_category.categoryId.eq(categoryId))
                .fetchFirst();

        return Optional.ofNullable(categoryEntity)
                .map(mapper::toCategory);
    }

    @Override
    public Category findBy(Long categoryId) {
        var categoryEntity = entityRepository.findByCategoryId(categoryId);
        return mapper.toCategory(categoryEntity);
    }

    @Override
    public List<Category> findByParentId(Long parentId) {
        // return mapper.toCategoryList(entityRepository.findByParentId(parentId));
        var _category = new QCategoryEntity("_category");
        var queryFactory = new JPAQueryFactory(em);

        return queryFactory
                .selectFrom(_category)
                .where(_category.parentId.eq(parentId))
                .stream()
                .map(mapper::toCategory)
                .toList();
    }
}
