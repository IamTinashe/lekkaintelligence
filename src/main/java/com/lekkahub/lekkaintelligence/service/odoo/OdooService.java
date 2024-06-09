package com.lekkahub.lekkaintelligence.service.odoo;


import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.model.Lead;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.apache.xmlrpc.XmlRpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OdooService {

    @Autowired
    private OdooClient odooClient;

    public List<Lead> getLeads(String email) throws IOException, XmlRpcException {
        return odooClient.getLeadsByEmail(email);
    }
}
