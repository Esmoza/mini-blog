package com.auk.project.miniblog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity()
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="role")
    private String role;
/*
    @ManyToOne(fetch = FetchType.LAZY)
    private Set<User> users;
*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
