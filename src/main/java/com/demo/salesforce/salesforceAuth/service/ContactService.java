/**
 * 
 */
package com.demo.salesforce.salesforceAuth.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import com.demo.salesforce.salesforceAuth.dao.ContactDao;
import com.demo.salesforce.salesforceAuth.model.Contact;

/**
 * @author mvelazquez
 *
 */
@Service
public class ContactService {
	
	@Autowired
	private ContactDao contactDao;

	@Autowired
	OAuth2RestTemplate oauthRestTemplate;

	private final Logger logger= LogManager.getLogger(ContactDao.class);

	public List<Contact> getContactsList(OAuth2Authentication principal){
		try {
			return contactDao.getContacts(principal);
		} catch (Exception e){
			logger.error("Something went wrong " + e.getMessage(), e);
			throw e;
		}
	}



}
