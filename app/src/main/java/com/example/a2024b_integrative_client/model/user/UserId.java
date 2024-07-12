package com.example.a2024b_integrative_client.model.user;

public class UserId {
    private String superapp;
    private String email;

    public UserId() {}

    public UserId(String superapp, String email) {
        this.superapp = superapp;
        this.email = email;
    }

    public String getSuperAPP() {
        return superapp;
    }

    public void setSuperAPP(String superApp) {
        this.superapp = superApp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserIdBoundary{" +
                "superapp='" + superapp + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}