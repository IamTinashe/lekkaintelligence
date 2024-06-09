package com.lekkahub.lekkaintelligence.service.salesforce;

import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.model.SalesforceTokenResponse;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@Service
public class SalesforceAuthenticator {

    private static final Logger logger = LoggerFactory.getLogger(SalesforceAuthenticator.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private RestTemplate restTemplate;

    public SalesforceTokenResponse authenticate() {
        logger.debug("Starting Salesforce authentication");

        AuthCredentials credentials = authService.getCredentialsByService("salesforce");
        String url = "https://login.salesforce.com/services/oauth2/token";

        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("client_id", credentials.getClientId());
        params.put("client_secret", credentials.getClientSecret());
        params.put("username", credentials.getUsername());
        params.put("password", credentials.getPassword());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(params, headers);

        try {
            ResponseEntity<SalesforceTokenResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, SalesforceTokenResponse.class);
            logger.debug("Salesforce authentication successful");
            return response.getBody();
        } catch (Exception e) {
            logger.error("Error during Salesforce authentication", e);
            throw new RuntimeException("Failed to authenticate with Salesforce", e);
        }
    }
}