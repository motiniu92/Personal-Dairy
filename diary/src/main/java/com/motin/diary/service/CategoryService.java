package com.motin.diary.service;

import com.motin.diary.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    List<Category> saveAll(List<Category> categories);
    void delete(Long id);
    List<Category> findAll();
    Category findById(Long id);
    Category findByCategoryName(String categoryName);
}
