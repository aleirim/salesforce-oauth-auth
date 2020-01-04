/**
 * 
 */
package com.demo.salesforce.salesforceAuth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;
import com.demo.salesforce.salesforceAuth.api.RestApi;
import com.demo.salesforce.salesforceAuth.model.Contact;

/**
 * @author mvelazquez
 *
 */
@Component
public class ContactDao extends QueryResult<Contact> {

	@Autowired
	private OAuth2RestTemplate oauthRestTemplate;

	@Autowired
	private RestApi restApi;

	private final Logger logger = LogManager.getLogger(ContactDao.class);
	
	public List<Contact> getContacts(OAuth2Authentication principal) {
		try {
			String query = "SELECT Id, Name, Phone, Email FROM Contact";
			String request = restApi.restRequestUrl(principal) + "query/?q={q}";
			Map<String, String> params = new HashMap<>();
			params.put("q", query);
			return oauthRestTemplate.getForObject(request, ContactDao.class, params).records;
			//return list;
		} catch(Exception e){
			logger.error("Something went wrong: " + e.getMessage(), e);
			throw e;
		}

	}

}
