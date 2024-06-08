package com.lekkahub.lekkaintelligence.service.odoo;


import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OdooService {

    @Autowired
    private OdooClient odooClient;

    @Autowired
    private AuthService authService;

    public String getOdooData() {
        AuthCredentials credentials = authService.getCredentialsByService("odoo");
        return odooClient.getData(credentials);
    }
}
