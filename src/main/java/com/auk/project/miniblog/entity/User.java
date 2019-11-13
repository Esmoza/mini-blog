package com.auk.project.miniblog.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastname;
}
