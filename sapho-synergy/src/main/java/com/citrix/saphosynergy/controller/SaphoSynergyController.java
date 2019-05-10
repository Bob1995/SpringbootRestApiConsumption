package com.citrix.saphosynergy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citrix.saphosynergy.model.JiraIssue;
import com.citrix.saphosynergy.model.JiraIssueResponse;
import com.citrix.saphosynergy.model.ServiceNowIncident;
import com.citrix.saphosynergy.model.SynergyApp;
import com.citrix.saphosynergy.model.SynergySaphoUser;
import com.citrix.saphosynergy.service.impl.JiraServiceImpl;
import com.citrix.saphosynergy.service.impl.ServiceNowServiceImpl;
import com.citrix.saphosynergy.service.impl.SynergyAppsServiceImpl;
import com.citrix.saphosynergy.service.impl.SynergySaphoUserServiceImpl;

@RestController
public class SaphoSynergyController {

	@Autowired
	private JiraServiceImpl jiraServiceImpl;

	@Autowired
	private SynergySaphoUserServiceImpl userService;
	
	@Autowired
	private SynergyAppsServiceImpl appsService;
	
	@PostMapping("/jira/issues")
	public ResponseEntity<JiraIssueResponse> createIssue(@RequestBody JiraIssue jiraIssue) {
		return jiraServiceImpl.createIssue(jiraIssue);
	}

	@PostMapping("/users")
	public ResponseEntity<SynergySaphoUser> createUser(@RequestBody SynergySaphoUser user) {
		SynergySaphoUser savedUser = userService.createUser(user);
		ResponseEntity<SynergySaphoUser> response = new ResponseEntity<SynergySaphoUser>(savedUser,
				HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/users")
	public ResponseEntity<List<SynergySaphoUser>> getAllUsers() {
		List<SynergySaphoUser> users = userService.getUsers();
		ResponseEntity<List<SynergySaphoUser>> response = new ResponseEntity<>(users, HttpStatus.OK);
		return response;
	}

	
	@PostMapping("/apps")
	public ResponseEntity<SynergyApp> addApp(@RequestBody SynergyApp app) {
		SynergyApp createdApp = appsService.createApp(app);
		ResponseEntity<SynergyApp> response = new ResponseEntity<>(createdApp,
				HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/apps")
	public ResponseEntity<List<SynergyApp>> getAllApps() {
		List<SynergyApp> apps = appsService.getAllApps();
		ResponseEntity<List<SynergyApp>> response = new ResponseEntity<>(apps, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<SynergySaphoUser> getUserById(@PathVariable("userId") Long userId) {
		Optional<SynergySaphoUser> user = userService.getUserById(userId);
		ResponseEntity<SynergySaphoUser> response = new ResponseEntity<>(user.get(), HttpStatus.OK);
		return response;
	}

}




















