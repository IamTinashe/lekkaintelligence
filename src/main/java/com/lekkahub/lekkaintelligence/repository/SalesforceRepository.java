package com.lekkahub.lekkaintelligence.repository;


import com.lekkahub.lekkaintelligence.service.salesforce.SalesforceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalesforceRepository {

    @Autowired
    private SalesforceService salesforceService;

    public String fetchData(String soqlQuery) {
        return salesforceService.getSalesforceData(soqlQuery);
    }
}

