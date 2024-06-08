package com.lekkahub.lekkaintelligence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports/sales-performance")
public class SalesPerformanceController {

    @Autowired
    private SalesPerformanceService salesPerformanceService;

    @GetMapping
    public String getSalesPerformanceReport() {
        return salesPerformanceService.getSalesPerformanceReport();
    }
}

