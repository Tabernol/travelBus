package com.travelbus.service.impl;

import com.travelbus.data.entity.User;
import com.travelbus.dto.dto.UserDto;
import com.travelbus.repo.UserRepo;
import com.travelbus.service.DtoService;
import com.travelbus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService, DtoService<UserDto, User> {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Iterable<UserDto> getAll() {
        return null;
    }

    @Override
    public UserDto get(Long id) {
        return toDto(userRepo.findById(id).orElse(new User()));
    }

    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    @Override
    public List<UserDto> toDto(Iterable<User> users) {
        return null;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return user;

    }
}
