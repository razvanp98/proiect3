package com.razvan.papurica.proiect3.entity;

import com.razvan.papurica.proiect3.security.SecurityAuthorizer;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "proiect3")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    // CONSTRUCTORS

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = SecurityAuthorizer.encrypt(password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role.replaceAll("\\s+", "").toUpperCase();
    }
}
