package com.travelbus.service;

import com.travelbus.entity.User;

public interface UserService extends BaseService<User> {

    User get(String login);
}
