package com.lekkahub.lekkaintelligence.service.odoo;

import com.lekkahub.lekkaintelligence.model.AuthCredentials;
import com.lekkahub.lekkaintelligence.service.AuthService;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
@Service
public class OdooDBConnector {

    private static final Logger logger = LoggerFactory.getLogger(OdooDBConnector.class);

    private final XmlRpcClient client;
    private final XmlRpcClientConfigImpl commonConfig;

    @Autowired
    private AuthService authService;

    public OdooDBConnector() {
        client = new XmlRpcClient();
        commonConfig = new XmlRpcClientConfigImpl();
    }

    public int authenticate(AuthCredentials odooCredentials) throws MalformedURLException, XmlRpcException {
        logger.debug("Starting Odoo authentication");

        commonConfig.setServerURL(new URL(String.format("%s/xmlrpc/2/common", odooCredentials.getUrl())));
        int uid = (int) client.execute(commonConfig, "authenticate", Collections.singletonList(new Object[]{
                odooCredentials.getDb(), odooCredentials.getUsername(), odooCredentials.getPassword(), Collections.emptyMap()
        }));
        logger.debug("Odoo authentication successful, UID: {}", uid);
        return uid;
    }

    public XmlRpcClient getAuthenticatedClient(AuthCredentials odooCredentials) throws MalformedURLException {
        logger.debug("Configuring authenticated client for Odoo");

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(String.format("%s/xmlrpc/2/object", odooCredentials.getUrl())));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        return client;
    }
}