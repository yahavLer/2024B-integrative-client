package com.example.a2024b_integrative_client.model.user;

import com.example.a2024b_integrative_client.RoleEnumBoundary;
import com.google.gson.Gson;

public class NewUserBoundary {

    private RoleEnumBoundary role;
    private String username;
    private String avatar;
    private String email;

    public NewUserBoundary(RoleEnumBoundary role, String username, String avatar, String email) {
        this.role = role;
        this.username = username;
        this.avatar = avatar;
        this.email = email;

    }

    public RoleEnumBoundary getRole() {
        return role;
    }

    public void setRole(RoleEnumBoundary role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "NewUserBoundary{" +
                "email='" + email + '\'' +
                ", role=" + role +
                ", userName='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}