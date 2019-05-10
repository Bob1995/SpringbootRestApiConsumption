package com.citrix.saphosynergy.model.tableau;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TableauUser {
	private String id;
	private String name;
	private String fullName;
	private String siteRole;
	private String authSetting;
	private String lastLogin;
	private String externalAuthUserId;
	private String domainName;

	@JsonProperty("domain")
	private void unpackNested(Map<String, Object> domain) {
		this.domainName = (String) domain.get("name");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSiteRole() {
		return siteRole;
	}

	public void setSiteRole(String siteRole) {
		this.siteRole = siteRole;
	}

	public String getAuthSetting() {
		return authSetting;
	}

	public void setAuthSetting(String authSetting) {
		this.authSetting = authSetting;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getExternalAuthUserId() {
		return externalAuthUserId;
	}

	public void setExternalAuthUserId(String externalAuthUserId) {
		this.externalAuthUserId = externalAuthUserId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	

}
