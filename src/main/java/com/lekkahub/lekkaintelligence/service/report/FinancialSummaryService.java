package com.lekkahub.lekkaintelligence.service.report;


import com.lekkahub.lekkaintelligence.repository.OdooRepository;
import com.lekkahub.lekkaintelligence.repository.SalesforceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialSummaryService {

    @Autowired
    private OdooRepository odooRepository;

    @Autowired
    private SalesforceRepository salesforceRepository;

    public String getFinancialSummaryReport() {
        // Implement logic to generate financial summary report using odooRepository and salesforceRepository
        return "Financial Summary Report";
    }
}

