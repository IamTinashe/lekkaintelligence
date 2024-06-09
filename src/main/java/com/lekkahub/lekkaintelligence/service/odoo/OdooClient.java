package com.lekkahub.lekkaintelligence.service.odoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.model.Lead;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class OdooClient {

    @Autowired
    private OdooDBConnector odooDBConnector;

    @Autowired
    private AuthService authService;

    public List<Lead> getLeadsByEmail(String email) throws IOException, XmlRpcException {
        AuthCredentials odooCredentials = authService.getCredentialsByService("odoo");
        XmlRpcClient client = odooDBConnector.getAuthenticatedClient(odooCredentials);
        int uid = odooDBConnector.authenticate(odooCredentials);

        List<Object> leadsObj = asList((Object[]) client.execute("execute_kw", asList(
                odooCredentials.getDb(), uid, odooCredentials.getPassword(),
                "crm.lead", "search_read",
                asList(asList(asList("email_from", "=", email))),
                new HashMap<String, Object>() {{
                    put("fields", asList("email_from"));
                    put("limit", 10000);
                }}
        )));

        ObjectMapper objectMapper = new ObjectMapper();
        List<Lead> leads = new ArrayList<>();
        for (Object obj : leadsObj) {
            Lead lead = objectMapper.convertValue(obj, Lead.class);
            leads.add(lead);
        }
        return leads;
    }
}