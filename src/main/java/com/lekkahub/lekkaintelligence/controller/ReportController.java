package com.lekkahub.lekkaintelligence.controller;

import com.lekkahub.lekkaintelligence.service.odoo.OdooService;
import com.lekkahub.lekkaintelligence.service.salesforce.SalesforceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private OdooService odooService;

    @Autowired
    private SalesforceService salesforceService;

//    @GetMapping("/odoo")
//    public String getOdooData() {
//        return odooService.getOdooData();
//    }
//
//    @GetMapping("/salesforce")
//    public String getSalesforceData() {
//        return salesforceService.getSalesforceData();
//    }
}

