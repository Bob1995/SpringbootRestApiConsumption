package com.citrix.saphosynergy.model;

import java.util.List;

public class JiraBaseResponse {
	
	private int maxResults;
    private int startAt;
    private int total;
    private String isLast;
    private List<JiraBoard> values;
	public int getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	public int getStartAt() {
		return startAt;
	}
	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getIsLast() {
		return isLast;
	}
	public void setIsLast(String isLast) {
		this.isLast = isLast;
	}
	public List<JiraBoard> getValues() {
		return values;
	}
	public void setValues(List<JiraBoard> values) {
		this.values = values;
	}
	
    
    

}
