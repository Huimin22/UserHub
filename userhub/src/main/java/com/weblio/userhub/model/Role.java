package com.weblio.userhub.model;

import jakarta.persistence.*;  // JPA annotations
import java.io.Serializable;

@Entity
@Table(name = "users")  // Maps this class to the "users" table in the database
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment primary key
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;  // Username, must be unique

    @Column(nullable = false, unique = true)
    private String email;     // Email, must be unique

    @Column(nullable = false)
    private String password;  // Password (should be stored encrypted)

    @Enumerated(EnumType.STRING)
    private Role role;        // User role: USER or ADMIN

    // ========================
    // Constructors
    // ========================
    public User() {}  // Default constructor required by JPA

    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // ========================
    // Getters and Setters
    // ========================
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
