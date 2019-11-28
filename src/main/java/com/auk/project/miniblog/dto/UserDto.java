package com.auk.project.miniblog.dto;

import com.auk.project.miniblog.entity.Role;
import lombok.Data;

import java.util.Set;
@Data
public class UserDto {

    private Long id;
    private String email;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int active;
    private Set<Role> roles;
}
