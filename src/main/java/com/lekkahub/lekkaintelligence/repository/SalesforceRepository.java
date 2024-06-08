package com.lekkahub.lekkaintelligence.repository;

import com.lekkahub.lekkaintelligence.service.saleforce.SalesforceClient;
import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalesforceRepository {

    @Autowired
    private SalesforceClient salesforceClient;

    @Autowired
    private AuthService authService;

    public String fetchData() {
        AuthCredentials credentials = authService.getCredentialsByService("salesforce");
        return salesforceClient.getData(credentials);
    }
}

