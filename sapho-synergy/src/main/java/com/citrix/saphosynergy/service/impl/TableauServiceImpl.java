package com.citrix.saphosynergy.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citrix.saphosynergy.model.tableau.TableauSignInRequest;
import com.citrix.saphosynergy.model.tableau.TableauSignInResponse;
import com.citrix.saphosynergy.model.tableau.TableauUserResponse;

@Service
public class TableauServiceImpl  {

	@Value("${tableau.userName}")
	private String userName;
	
	@Value("${tableau.password}")
	private String password;
	
	@Value("${tableau.contentUrl}")
	private String contentUrl;
	
	@Value("${tableau.getUserUrl}")
	private String getUserUrl;
	
	@Value("${tableau.signInUrl}")
	private String signInUrl;
	
	public TableauSignInResponse signIn(RestTemplate restTemplate) {		
		TableauSignInRequest  request = generateJsonSignInRequest();		
		HttpEntity<TableauSignInRequest> entity = new HttpEntity<>(request, generateHeaders());
		ResponseEntity<TableauSignInResponse> response = restTemplate.exchange(
				signInUrl, HttpMethod.POST, entity,
				TableauSignInResponse.class);
		TableauSignInResponse signInResponse = response.getBody();
		return signInResponse;
	}
	
	public TableauUserResponse getUser() {
		RestTemplate restTemplate = new RestTemplate();
		TableauSignInResponse signInResponse = signIn(restTemplate);
		HttpHeaders headers = generateHeaders();
		headers.add("X-Tableau-Auth", signInResponse.getToken());
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<TableauUserResponse> response = restTemplate.exchange(
				getUserUrl, HttpMethod.GET, entity,
				TableauUserResponse.class, signInResponse.getSiteId(), signInResponse.getUserId());
		return response.getBody();
		
	}
	private HttpHeaders generateHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		return headers;
	}
	
	private TableauSignInRequest generateJsonSignInRequest() {
		TableauSignInRequest  request = new TableauSignInRequest();
		Map<String, String> site = new HashMap<String, String>();
		site.put("contentUrl", contentUrl);
		
		Map<String, Object> credentials = new HashMap<String, Object>();
		credentials.put("name", userName);
		credentials.put("password", password);
		credentials.put("site", site);
		
		request.setCredentials(credentials);
		return request;
	}

	


	
	
	

}
