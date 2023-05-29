package com.travelbus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String password;


    @OneToMany(mappedBy = "user")
//    @JsonIgnore
    private List<Ticket> tickets;
//    private Role role;



//    public enum Role{
//        PASSENGER,
//        ADMIN;
//    }
}
