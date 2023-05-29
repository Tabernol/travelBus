package com.travelbus.mapper.impl;

import com.travelbus.entity.User;
import com.travelbus.dto.get.UserGetDto;
import com.travelbus.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserGetDto userToUserGetDto(User user) {
        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setLogin(user.getLogin());
        userGetDto.setName(user.getName());
        userGetDto.setTicketList(user.getTickets());
        return userGetDto;
    }
}
