package com.travelbus.mapper;

import com.travelbus.entity.User;
import com.travelbus.dto.get.UserGetDto;

public interface UserMapper {
    UserGetDto userToUserGetDto(User user);
}
