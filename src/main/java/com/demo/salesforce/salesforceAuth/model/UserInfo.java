package com.demo.salesforce.salesforceAuth.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private String OrganizationType;
    private String Name;
    private String UserName;
    private String OrgId;
}
