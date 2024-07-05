package com.example.a2024b_integrative_client.model.user;

public class UserId {
    private String superApp;
    private String email;

    public UserId() {}

    public UserId(String superapp, String email) {
        this.superApp = superapp;
        this.email = email;
    }

    public String getSuperAPP() {
        return superApp;
    }

    public void setSuperAPP(String superApp) {
        this.superApp = superApp;
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
                "superapp='" + superApp + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}