package com.lekkahub.lekkaintelligence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports/customer-segmentation")
public class CustomerSegmentationController {

    @Autowired
    private CustomerSegmentationService customerSegmentationService;

    @GetMapping
    public String getCustomerSegmentationReport() {
        return customerSegmentationService.getCustomerSegmentationReport();
    }
}
