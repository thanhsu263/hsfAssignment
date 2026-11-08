package com.thanhsu.crud.entity;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, unique = true) private String email;
    @Column(nullable = false) private String password;
    /** 1 = admin, 2 = staff, 3 = blocked. */
    @Column(nullable = false) private int role;
    public Account() { }
    public Account(String email, String password, int role) { this.email = email; this.password = password; this.role = role; }
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getRole() { return role; }
    public boolean isAdmin() { return role == 1; }
    public String getRoleLabel() { return switch (role) { case 1 -> "Admin"; case 2 -> "Staff"; default -> "Blocked"; }; }
}
