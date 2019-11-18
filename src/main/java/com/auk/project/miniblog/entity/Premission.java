package com.auk.project.miniblog.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="premission")
@Entity
public class Premission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
