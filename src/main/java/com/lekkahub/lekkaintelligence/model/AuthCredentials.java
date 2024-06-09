package com.lekkahub.lekkaintelligence.model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
public class AuthCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String service;
    private String url;
    private String db;
    private String username;
    private String password;
    private String clientId;
    private String clientSecret;
}

