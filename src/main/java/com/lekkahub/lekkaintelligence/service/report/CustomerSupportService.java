package com.lekkahub.lekkaintelligence.service.report;

import com.lekkahub.lekkaintelligence.repository.OdooRepository;
import com.lekkahub.lekkaintelligence.repository.SalesforceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSupportService {

    @Autowired
    private OdooRepository odooRepository;

    @Autowired
    private SalesforceRepository salesforceRepository;

    public String getCustomerSupportReport() {
        // Implement logic to generate customer support report using odooRepository and salesforceRepository
        return "Customer Support Report";
    }
}
