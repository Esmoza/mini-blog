package com.auk.project.miniblog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name="user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="email")
    private String email;
    @Column(name = "user_name")
    private String username;
    @Column(name="password")
    private String password;
    private int active=1;
    @ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST)
    private Set<Role> roles;
    private String permissions="";


}
