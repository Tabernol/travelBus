package com.travelbus.controller;

import com.travelbus.dto.get.UserGetDto;
import com.travelbus.mapper.UserMapper;
import com.travelbus.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/users/{id}")
    public UserGetDto getUser(@PathVariable(name = "id") Long id) {
        return userMapper.userToUserGetDto(userService.get(id));
    }


}
