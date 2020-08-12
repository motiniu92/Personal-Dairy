package com.motin.diary.controller;

import com.motin.diary.dto.CategoryRequestDto;
import com.motin.diary.dto.UserRequestDto;
import com.motin.diary.entity.Category;
import com.motin.diary.entity.User;
import com.motin.diary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public List<User> findAllActiveUsers() {
        return userService.findAll();
    }


    @GetMapping(path = "/find")
    public User findUser(@Validated @RequestBody UserRequestDto userRequestDto){
    return userService.findById(userRequestDto.getId());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<User> save(@Validated @RequestBody User user) {
        return ResponseEntity.ok().body(userService.save(user));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> delete(@Validated @RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok().body("Deleted successfully");
    }
}
