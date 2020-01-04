/**
 * 
 */
package com.demo.salesforce.salesforceAuth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

/**
 * @author mvelazquez
 *
 */

@JsonIgnoreProperties
public class Contact implements Serializable {
	public String Id;
	public String Name;
	public String Phone;
	public String Email;
}
