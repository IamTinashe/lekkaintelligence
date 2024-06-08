package com.lekkahub.lekkaintelligence.controller;


import com.lekkahub.lekkaintelligence.service.report.CustomerSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports/customer-support")
public class CustomerSupportController {

    @Autowired
    private CustomerSupportService customerSupportService;

    @GetMapping
    public String getCustomerSupportReport() {
        return customerSupportService.getCustomerSupportReport();
    }
}

