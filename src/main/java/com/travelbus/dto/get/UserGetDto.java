package com.travelbus.dto.get;

import com.travelbus.entity.Ticket;
import lombok.Data;

import java.util.List;

@Data
public class UserGetDto {
    private String name;
    private String login;
    private List<Ticket> ticketList;
}
