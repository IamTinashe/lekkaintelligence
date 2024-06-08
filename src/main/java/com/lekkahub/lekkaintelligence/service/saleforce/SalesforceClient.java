package com.lekkahub.lekkaintelligence.service.saleforce;


import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class SalesforceClient {

    public String getData(AuthCredentials credentials) {
        try {
            String query = "SELECT Id, Name, Email FROM Contact";
            String url = credentials.getUrl() + "/services/data/v50.0/query?q=" + query;

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(credentials.getPassword());
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching data from Salesforce";
        }
    }
}

