package com.citrix.saphosynergy.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.citrix.saphosynergy.model.ServiceNowCreateIncidentResponse;
import com.citrix.saphosynergy.model.ServiceNowIncident;
import com.citrix.saphosynergy.model.ServiceNowIncidentResponse;
import com.citrix.saphosynergy.model.ServiceNowUser;
import com.citrix.saphosynergy.model.ServiceNowUserResponse;
import com.citrix.saphosynergy.service.ServiceNowService;

@Service
public class ServiceNowServiceImpl implements ServiceNowService {

	public List<ServiceNowIncident> getIncidents(String userName) {

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(generateHeaders());
		ServiceNowUser user = getUserIdByUserName(userName);

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromUriString("https://dev52126.service-now.com/api/now/table/incident")
				.queryParam("assigned_to", user.getSys_id());

		ResponseEntity<ServiceNowIncidentResponse> response = restTemplate.exchange(builder.toUriString(),
				HttpMethod.GET, entity, ServiceNowIncidentResponse.class);
		List<ServiceNowIncident> incidents = response.getBody().getResult();
		System.out.println(incidents);
		return incidents;

	}

	public ServiceNowIncident createIncident(String shortDescription) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceNowIncident incident = new ServiceNowIncident();
		incident.setShortDescription(shortDescription);
		HttpEntity<ServiceNowIncident> entity = new HttpEntity<>(incident, generateHeaders());
		ResponseEntity<ServiceNowCreateIncidentResponse> response = restTemplate.exchange(
				"https://dev52126.service-now.com/api/now/table/incident", HttpMethod.POST, entity,
				ServiceNowCreateIncidentResponse.class);
		ServiceNowIncident createdIncident = response.getBody().getResult();
		return createdIncident;
	}

	private HttpHeaders generateHeaders() {
		String encodedString = generateEncodedAuthString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + encodedString);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	private String generateEncodedAuthString() {
		String userDetails = "admin:Bhaskar@735";
		String encodedString = Base64.getEncoder().encodeToString(userDetails.getBytes());
		return encodedString;
	}

	private ServiceNowUser getUserIdByUserName(String userName) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(generateHeaders());

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromUriString("https://dev52126.service-now.com/api/now/table/sys_user")
				.queryParam("user_name", userName);
		ResponseEntity<ServiceNowUserResponse> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				entity, ServiceNowUserResponse.class);
		List<ServiceNowUser> user = response.getBody().getResult();
		return user.get(0);
	}

}
