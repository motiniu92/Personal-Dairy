package com.motin.diary.service.serviceImpl;

import com.motin.diary.entity.User;
import com.motin.diary.entity.User;
import com.motin.diary.repository.UserRepository;
import com.motin.diary.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User save(User user) {
        if(user != null){
            user = userRepository.save(user);
            log.info("user:{}",user);
        }
        return user;
    }

    @Override
    public List<User> saveAll(List<User> categories) {
        if(categories !=null && !categories.isEmpty()){
            categories = userRepository.saveAll(categories);
            log.info("categories:{}",categories);
        }
        return categories;
    }

    @Override
    public void delete(Long id) {
        if(id != null){
            User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
            userRepository.delete(user);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> categories = userRepository.findAll();
        log.info("categories:{}",categories);
        return categories;
    }

    @Override
    public User findById(Long id) {
        User user  = null;
        if(id != null){
            Optional<User> optionalUser = userRepository.findById(id);
            if(optionalUser.isPresent()){
                user = optionalUser.get();
            }else {
                throw new RuntimeException("User not found");
            }
        }else {
            throw new RuntimeException("Invalid id");
        }
        log.info("user:{}",user);
        return user;
    }

    @Override
    public User findByPhone(String phone) {
        User user = null;
        if(!StringUtils.isEmpty(phone)){
            user = userRepository.findByPhone(phone);
        }
        return user;
    }
}
