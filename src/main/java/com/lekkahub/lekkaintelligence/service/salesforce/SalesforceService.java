package com.lekkahub.lekkaintelligence.service.salesforce;

import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SalesforceService {

    @Autowired
    private SalesforceClient salesforceClient;

    public String getSalesforceData(String soqlQuery) {
        return salesforceClient.fetchData(soqlQuery);
    }
}

