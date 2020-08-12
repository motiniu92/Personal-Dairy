package com.motin.diary.service;

import com.motin.diary.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class TestCategoryService {
    @Autowired
    private CategoryService categoryService;
    @Test
    public void insertCategories(){
        Category category1 = new Category();
        category1.setCategoryName("All");

        Category category2 = new Category();
        category2.setCategoryName("Home");

        Category category3 = new Category();
        category3.setCategoryName("Work");

        Category category4 = new Category();
        category4.setCategoryName("Others");

        List<Category> categories = categoryService.saveAll(Arrays.asList(category1,category2,category3,category4));
        log.info("categories:{}",categories);
    }


}
