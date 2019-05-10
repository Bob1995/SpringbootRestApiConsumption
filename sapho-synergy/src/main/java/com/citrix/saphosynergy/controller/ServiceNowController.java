package com.citrix.saphosynergy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.citrix.saphosynergy.model.ServiceNowIncident;
import com.citrix.saphosynergy.service.impl.ServiceNowServiceImpl;

@Controller
public class ServiceNowController {
	
	@Autowired
	private ServiceNowServiceImpl serviceNowService;
	
	@GetMapping("/service-now/incidents")
	public ResponseEntity<List<ServiceNowIncident>> getServiceNowIncidentsByUserName(@RequestParam("userName") String userName) {
		List<ServiceNowIncident> incidents = serviceNowService.getIncidents(userName);
		ResponseEntity<List<ServiceNowIncident>> response = new ResponseEntity<>(incidents, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/service-now/incidents")
	public ResponseEntity<ServiceNowIncident> createServiceNowIncident(@RequestParam("shortDescription") String desc) {
		ServiceNowIncident createdIncident = serviceNowService.createIncident(desc);
		ResponseEntity<ServiceNowIncident> response = new ResponseEntity<>(createdIncident, HttpStatus.CREATED);
		return response;
	}
	
}
