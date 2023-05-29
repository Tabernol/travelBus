package com.travelbus.service.impl;

import com.travelbus.entity.User;
import com.travelbus.repo.UserRepo;
import com.travelbus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Iterable<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepo.findById(id).orElseThrow();
    }

    @Override
    public User get(String login) {
        return userRepo.findByLogin(login);
    }



    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }



}
