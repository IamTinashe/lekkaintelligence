package com.lekkahub.lekkaintelligence.service.report;

import com.lekkahub.lekkaintelligence.repository.OdooRepository;
import com.lekkahub.lekkaintelligence.repository.SalesforceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesPerformanceService {

    @Autowired
    private OdooRepository odooRepository;

    @Autowired
    private SalesforceRepository salesforceRepository;

    public String getSalesPerformanceReport() {
        // Implement logic to generate sales performance report using odooRepository and salesforceRepository
        return "Sales Performance Report";
    }
}

