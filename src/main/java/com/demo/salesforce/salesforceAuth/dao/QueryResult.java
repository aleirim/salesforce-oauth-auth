/**
 * 
 */
package com.demo.salesforce.salesforceAuth.dao;

import java.util.List;

/**
 * @author mvelazquez
 *
 */
public class QueryResult <T> {
	
	public List<T> records;
	
	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

}
