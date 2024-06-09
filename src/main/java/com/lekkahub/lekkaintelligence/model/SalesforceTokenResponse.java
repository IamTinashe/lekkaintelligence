package com.lekkahub.lekkaintelligence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesforceTokenResponse {
    private String accessToken;
    private String instanceUrl;
    private String id;
    private String tokenType;
    private String issuedAt;
    private String signature;
}
