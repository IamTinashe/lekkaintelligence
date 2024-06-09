package com.lekkahub.lekkaintelligence.repository;

import com.lekkahub.lekkaintelligence.model.Lead;
import com.lekkahub.lekkaintelligence.service.odoo.OdooClient;
import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.apache.xmlrpc.XmlRpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class OdooRepository {

    @Autowired
    private OdooClient odooClient;

    @Autowired
    private AuthService authService;

    public List<Lead> fetchLeads(String email) throws IOException, XmlRpcException {
        AuthCredentials credentials = authService.getCredentialsByService("odoo");
        return odooClient.getLeadsByEmail(email);
    }
}
