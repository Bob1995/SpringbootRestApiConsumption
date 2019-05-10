package com.citrix.saphosynergy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citrix.saphosynergy.model.tableau.TableauUserResponse;
import com.citrix.saphosynergy.service.impl.TableauServiceImpl;

@RestController
public class TableauController {
	@Autowired
	private TableauServiceImpl tableauService;

	@GetMapping("/tableau/users")
	public ResponseEntity<TableauUserResponse> createSignInRequest() {
		TableauUserResponse user = tableauService.getUser();
		ResponseEntity<TableauUserResponse> response = new ResponseEntity<TableauUserResponse>(user, HttpStatus.OK);
		return response;

	}

}
