package com.citrix.saphosynergy.model.tableau;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TableauSignInResponse {

	private String siteId;
	private String contentUrl;
	private String userId;
	private String token;

	@SuppressWarnings("unchecked")
	@JsonProperty("credentials")
	private void unpackNested(Map<String, Object> credentails) {
		this.token = (String) credentails.get("token");

		Map<String, String> user = (Map<String, String>) credentails.get("user");
		this.userId = user.get("id");

		Map<String, String> site = (Map<String, String>) credentails.get("site");
		this.siteId = site.get("id");
		this.contentUrl = site.get("contentUrl");
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
