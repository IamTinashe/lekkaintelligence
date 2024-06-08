package com.lekkahub.lekkaintelligence.service.saleforce;

import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesforceService {

    @Autowired
    private SalesforceClient salesforceClient;

    @Autowired
    private AuthService authService;

    public String getSalesforceData() {
        AuthCredentials credentials = authService.getCredentialsByService("salesforce");
        return salesforceClient.getData(credentials);
    }
}

