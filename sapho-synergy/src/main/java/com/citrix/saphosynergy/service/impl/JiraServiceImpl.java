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

import com.citrix.saphosynergy.model.JiraBaseResponse;
import com.citrix.saphosynergy.model.JiraBoard;
import com.citrix.saphosynergy.model.JiraIssue;
import com.citrix.saphosynergy.model.JiraIssueResponse;

@Service
public class JiraServiceImpl {

	public List<JiraBoard> getBoards() {
		RestTemplate restTemplate = new RestTemplate();
		String encodedString = generateEncodedAuthString();
		HttpHeaders headers = generateHeaders(encodedString);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<JiraBaseResponse> response = restTemplate.exchange(
				"https://bhaskar735.atlassian.net/rest/agile/1.0/board", HttpMethod.GET, entity,
				JiraBaseResponse.class);
		List<JiraBoard> boards = response.getBody().getValues();
		return boards;
	}

	public ResponseEntity<JiraIssueResponse> createIssue(JiraIssue jiraIssue) {
		RestTemplate restTemplate = new RestTemplate();
		String encodedString = generateEncodedAuthString();
		HttpHeaders headers = generateHeaders(encodedString);
		HttpEntity<JiraIssue> entity = new HttpEntity<>(jiraIssue, headers);
		ResponseEntity<JiraIssueResponse> response = restTemplate.exchange(
				"https://bhaskar735.atlassian.net/rest/api/2/issue", HttpMethod.POST, entity, JiraIssueResponse.class);
		return response;
	}

	private HttpHeaders generateHeaders(String encodedString) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + encodedString);
		headers.setContentType(MediaType.APPLICATION_JSON);
		System.out.println(headers);
		return headers;
	}

	private String generateEncodedAuthString() {
		String userDetails = "bhaskar_srkr@yahoo.co.in:zEcdJ2ehlNGeLEL7ydmq6EF3";
		String encodedString = Base64.getEncoder().encodeToString(userDetails.getBytes());
		return encodedString;
	}

}
