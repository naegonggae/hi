package com.springbootmaven.hi.controller;

import com.springbootmaven.hi.dao.UserDao;
import com.springbootmaven.hi.domain.User;
import com.springbootmaven.hi.domain.dto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }
    /* 위에 대신 써도 정상작동하긴 해
    @Autowired
    private UserDao userDao;

     */

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable String id) {
        try {
            User user = this.userDao.findById(id);
            return ResponseEntity
                    .ok()
                    .body(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("")
    public ResponseEntity<Integer> add(@RequestBody UserRequestDto userRequestDto) {

        User user = new User(userRequestDto.getId(), userRequestDto.getName(), userRequestDto.getPassword());
        return ResponseEntity
                .ok()
                .body(userDao.add(user));
    }

    @DeleteMapping("")
    public ResponseEntity<Integer> deleteAll() {

        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
}
