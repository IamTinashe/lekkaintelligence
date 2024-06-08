package com.lekkahub.lekkaintelligence.service.report;

import com.lekkahub.lekkaintelligence.repository.OdooRepository;
import com.lekkahub.lekkaintelligence.repository.SalesforceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSegmentationService {

    @Autowired
    private OdooRepository odooRepository;

    @Autowired
    private SalesforceRepository salesforceRepository;

    public String getCustomerSegmentationReport() {
        // Implement logic to generate customer segmentation report using odooRepository and salesforceRepository
        return "Customer Segmentation Report";
    }
}
