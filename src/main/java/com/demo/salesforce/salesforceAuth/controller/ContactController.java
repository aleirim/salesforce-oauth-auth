/**
 * 
 */
package com.demo.salesforce.salesforceAuth.controller;

import com.demo.salesforce.salesforceAuth.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.demo.salesforce.salesforceAuth.service.ContactService;

/**
 * @author mvelazquez
 */

@Controller
public class ContactController {
	
	@Autowired
	ContactService contactService;

	@Autowired
	UserInfoService userService;

	@RequestMapping("/")
	public String getConList(OAuth2Authentication principal, Model model){
		try {
			model.addAttribute("contacts", contactService.getContactsList(principal));
			model.addAttribute("userInfo",userService.getUserInfo(principal));
			return "index";
		}
		catch (Exception e){
			throw new RuntimeException(e);
		}

	}



}
