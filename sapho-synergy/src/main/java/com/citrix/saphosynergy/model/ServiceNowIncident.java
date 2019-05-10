package com.citrix.saphosynergy.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ServiceNowIncident {

	private String parent;
	private String madeSla;
	private String causedBy;
    private String number;
    private String shortDescription;
    
	public String getParent() {
		return parent;
	}

	public String getMadeSla() {
		return madeSla;
	}

	public void setMadeSla(String madeSla) {
		this.madeSla = madeSla;
	}

	public String getCausedBy() {
		return causedBy;
	}

	public void setCausedBy(String causedBy) {
		this.causedBy = causedBy;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}	
	
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

}
