/**
 * 
 */
package com.demo.salesforce.salesforceAuth.api;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

/**
 * @author mvelazquez
 *
 */
@Component
public class RestApi {
	
	@Bean
	private OAuth2RestTemplate oAuth2RestTemplate(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
        return new OAuth2RestTemplate(resource, context);
    }
 
	@Autowired
    private OAuth2RestTemplate restTemplate;

    @Value("${rest-version}")
    private String REST_VERSION;

    @SuppressWarnings("unchecked")
	public String restRequestUrl(OAuth2Authentication principal) {
        HashMap<String, Object> details = (HashMap<String, Object>) principal.getUserAuthentication().getDetails();
        HashMap<String, String> urls = (HashMap<String, String>) details.get("urls");
        return urls.get("rest").replace("{version}", REST_VERSION);
    }

    //getting values from principal
    public  String getSingleParameterFromPrincipal(OAuth2Authentication principal, String param){
        HashMap<String, Object> details = (HashMap<String, Object>) principal.getUserAuthentication().getDetails();
        return details.get(param).toString();
    }
}
