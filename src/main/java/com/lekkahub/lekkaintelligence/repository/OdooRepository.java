package com.lekkahub.lekkaintelligence.repository;

import com.lekkahub.lekkaintelligence.service.odoo.OdooClient;
import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OdooRepository {

    @Autowired
    private OdooClient odooClient;

    @Autowired
    private AuthService authService;

    public String fetchData() {
        AuthCredentials credentials = authService.getCredentialsByService("odoo");
        return odooClient.getData(credentials);
    }
}
