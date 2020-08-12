package com.motin.diary.controller;

import com.motin.diary.dto.CategoryRequestDto;
import com.motin.diary.dto.UserRequestDto;
import com.motin.diary.entity.Category;
import com.motin.diary.entity.User;
import com.motin.diary.service.CategoryService;
import com.motin.diary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Category> save(@Validated @RequestBody Category category) {
        return ResponseEntity.ok().body(categoryService.save(category));
    }

    @GetMapping(path = "/all")
    public List<Category> findAllCategory() {
        return categoryService.findAll();
    }

    @PostMapping(path = "/find")
    public ResponseEntity<Category> find(@Validated @RequestBody CategoryRequestDto categoryRequestDto) {
        Category category = categoryService.findById(categoryRequestDto.getId());
        if (category == null) {
            return (ResponseEntity<Category>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> delete(@Validated @RequestBody CategoryRequestDto categoryRequestDto){
        categoryService.delete(categoryRequestDto.getId());
        return ResponseEntity.ok().body("Deleted successfully");
    }
}
