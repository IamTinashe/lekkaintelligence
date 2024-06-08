package com.lekkahub.lekkaintelligence.service.odoo;

import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class OdooClient {

    public String getData(AuthCredentials credentials) {
        try {
            XmlRpcClient client = new XmlRpcClient(credentials.getUrl() + "/xmlrpc/2/object");
            Object[] params = new Object[]{
                    credentials.getUrl(), 1, credentials.getPassword(), "crm.lead", "search_read",
                    new Object[]{new Object[]{new Object[]{"id", "!=", 0}}},
                    new HashMap<String, Object>() {{
                        put("fields", new String[]{"id", "name", "email_from"});
                    }}
            };
            Object[] result = (Object[]) client.execute("execute_kw", params);
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching data from Odoo";
        }
    }
}
