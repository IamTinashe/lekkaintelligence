package com.lekkahub.lekkaintelligence.service.salesforce;


import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.model.SalesforceTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
@Component
public class SalesforceClient {

    @Autowired
    private SalesforceAuthenticator salesforceAuthenticator;

    @Autowired
    private RestTemplate restTemplate;

    public String fetchData(String soqlQuery) {
        SalesforceTokenResponse tokenResponse = salesforceAuthenticator.authenticate();

        String url = tokenResponse.getInstanceUrl() + "/services/data/v50.0/query?q=" + soqlQuery;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tokenResponse.getAccessToken());
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}