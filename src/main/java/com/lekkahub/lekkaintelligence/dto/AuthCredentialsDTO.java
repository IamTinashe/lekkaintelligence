package com.lekkahub.lekkaintelligence.dto;

import lombok.Data;

@Data
public class AuthCredentialsDTO {

    private String service;
    private String url;
    private String username;
    private String password;
}
