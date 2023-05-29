package com.travelbus.repo;

import com.travelbus.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

    User findByLogin(String login);
}
