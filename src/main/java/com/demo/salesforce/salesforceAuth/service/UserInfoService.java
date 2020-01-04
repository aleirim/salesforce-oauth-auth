package com.demo.salesforce.salesforceAuth.service;

import com.demo.salesforce.salesforceAuth.dao.UserInfoDao;
import com.demo.salesforce.salesforceAuth.model.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfo;
    private final Logger logger = LogManager.getLogger(UserInfoService.class);

    public UserInfo getUserInfo(OAuth2Authentication session){
        try {
            return  userInfo.getUserInfo(session);
        } catch(Exception e){
            logger.error("Something went wrong: " + e.getMessage(),e);
            throw e;
        }

    }
}
