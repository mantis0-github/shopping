package com.project.shopping.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;


@Data
@Entity
@Table(name = "users")

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;

    private boolean active;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    Date createdAt = new Date();
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    Date updatedAt = new Date();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Roles> roles;
}
