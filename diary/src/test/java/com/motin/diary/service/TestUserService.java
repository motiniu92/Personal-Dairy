package com.motin.diary.service;

import com.motin.diary.entity.Category;
import com.motin.diary.entity.Note;
import com.motin.diary.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class TestUserService {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private NoteService noteService;

    @Test
    public void insertUsers() {
        User user1 = new User();
        user1.setUserName("Motin");
        user1.setPhone("01624967336");
        user1.setPassword("1234");

        User user2 = new User();
        user2.setUserName("Shawkat");
        user2.setPhone("01724967336");
        user2.setPassword("1234");

        User user3 = new User();
        user3.setUserName("Shetu");
        user3.setPhone("01824967336");
        user3.setPassword("1234");

        List<User> users = userService.saveAll(Arrays.asList(user1, user2, user3));
        log.info("users:{}", users);
    }


    @Test
    public void testUserCategoryUpdate() {
        User user = userService.findByPhone("01624967336");
        Category category1 = categoryService.findByCategoryName("Home");
        Category category2 = categoryService.findByCategoryName("Work");
        List<Category> categories = Arrays.asList(category1, category2);
        user.setCategories(categories);
        user = userService.save(user);
        log.info("user:{}", user);
    }

    @Test
    public void findByPhoneNumber() {
        User user = userService.findByPhone("01724967336");
        log.info("user:{}", user);
    }

    @Test
    public void testDeleteUserAndDeleteNotesButCategoryRemains() {
        User user = userService.findByPhone("01724967336");
        userService.delete(user.getId());
    }

    @Test
    public void testUpdateNote() {
        List<Note> notes = noteService.findAll();
        User user = new User();
        user.setPhone("01724967336");
        user = userService.findByPhone(user.getPhone());
        user.setNotes(notes);
        user = userService.save(user);
        log.info("user:{}", user);
    }

}
