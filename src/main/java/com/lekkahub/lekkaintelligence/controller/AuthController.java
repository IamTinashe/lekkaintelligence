package com.lekkahub.lekkaintelligence.controller;


import com.lekkahub.lekkaintelligence.dto.AuthCredentialsDTO;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/credentials")
    public void saveCredentials(@RequestBody AuthCredentialsDTO authCredentialsDTO) {
        authService.saveCredentials(authCredentialsDTO);
    }
}
