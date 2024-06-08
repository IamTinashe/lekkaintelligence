package com.lekkahub.lekkaintelligence.controller;

import com.lekkahub.lekkaintelligence.service.report.InventoryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports/inventory-management")
public class InventoryManagementController {

    @Autowired
    private InventoryManagementService inventoryManagementService;

    @GetMapping
    public String getInventoryManagementReport() {
        return inventoryManagementService.getInventoryManagementReport();
    }
}

