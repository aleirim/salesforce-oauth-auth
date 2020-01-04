package com.demo.salesforce.salesforceAuth.dao;

import com.demo.salesforce.salesforceAuth.api.RestApi;
import com.demo.salesforce.salesforceAuth.model.OrganizationInfo;
import com.demo.salesforce.salesforceAuth.model.UserInfo;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserInfoDao extends QueryResult<OrganizationInfo> {
    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Autowired
    private RestApi restApi;

    private final Logger logger = LogManager.getLogger(UserInfoDao.class);

    @SneakyThrows
    public UserInfo getUserInfo(OAuth2Authentication principal){
        try {
            String request= restApi.restRequestUrl(principal)+"query/?q={q}";
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(restApi.getSingleParameterFromPrincipal(principal, "preferred_username"));
            userInfo.setOrgId(restApi.getSingleParameterFromPrincipal(principal,"organization_id"));

            //getting org type and name by querying data
            Map<String, String> params = new HashMap<>();
            params.put("q", "SELECT Name, OrganizationType FROM Organization");
            List<OrganizationInfo> listOrganizationInfo = restTemplate.getForObject(request, UserInfoDao.class, params).records;

            userInfo.setName(listOrganizationInfo.get(0).Name);
            userInfo.setOrganizationType(listOrganizationInfo.get(0).OrganizationType);
            return userInfo;
        } catch (Exception e){
            logger.error("Something went wrong: " + e.getMessage(), e);
            throw e;
        }

    }
}
