package com.citrix.saphosynergy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citrix.saphosynergy.model.SynergyApp;
import com.citrix.saphosynergy.repository.SynergyAppsRepository;

@Service
public class SynergyAppsServiceImpl {

	@Autowired
	private SynergyAppsRepository appsRepository;

	public SynergyApp createApp(SynergyApp app) {
		SynergyApp savedApp = appsRepository.save(app);
		System.out.println("App created successfully with ID: " + savedApp.getId());
		return savedApp;
	}

	public List<SynergyApp> getAllApps() {
		List<SynergyApp> apps = appsRepository.findAll();
		System.out.println("Users retrieved successfully..List size: " + apps.size());
		return apps;
	}

}

