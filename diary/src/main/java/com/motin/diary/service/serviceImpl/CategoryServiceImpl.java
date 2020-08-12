package com.motin.diary.service.serviceImpl;

import com.motin.diary.entity.Category;
import com.motin.diary.repository.CategoryRepository;
import com.motin.diary.service.CategoryService;
import com.motin.diary.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category save(Category category) {
        if(category != null){
            category = categoryRepository.save(category);
            log.info("category:{}",category);
        }
        return category;
    }

    @Override
    public List<Category> saveAll(List<Category> categories) {
        if(categories !=null && !categories.isEmpty()){
            categories = categoryRepository.saveAll(categories);
            log.info("categories:{}",categories);
        }
        return categories;
    }

    @Override
    public void delete(Long id) {
        if(id != null){
            Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
            categoryRepository.delete(category);
        }
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        log.info("categories:{}",categories);
        return categories;
    }

    @Override
    public Category findById(Long id) {
        Category category  = null;
        if(id != null){
            Optional<Category> optionalCategory = categoryRepository.findById(id);
            if(optionalCategory.isPresent()){
                category = optionalCategory.get();
            }else {
                throw new RuntimeException("Category not found");
            }
        }else {
            throw new RuntimeException("Invalid id");
        }
        log.info("category:{}",category);
        return category;
    }

    @Override
    public Category findByCategoryName(String categoryName) {
        Category category = null;
        if(!StringUtils.isEmpty(categoryName)){
            category = categoryRepository.findByCategoryName(categoryName);
        }
        return category;
    }
}
