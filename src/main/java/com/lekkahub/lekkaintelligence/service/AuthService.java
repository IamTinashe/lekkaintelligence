package com.lekkahub.lekkaintelligence.service;


import com.lekkahub.lekkaintelligence.dto.AuthCredentialsDTO;
import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public void saveCredentials(AuthCredentialsDTO authCredentialsDTO) {
        AuthCredentials credentials = new AuthCredentials();
        credentials.setService(authCredentialsDTO.getService());
        credentials.setUrl(authCredentialsDTO.getUrl());
        credentials.setUsername(authCredentialsDTO.getUsername());
        credentials.setPassword(authCredentialsDTO.getPassword());
        authRepository.save(credentials);
    }

    public AuthCredentials getCredentialsByService(String service) {
        return authRepository.findByService(service);
    }
}

