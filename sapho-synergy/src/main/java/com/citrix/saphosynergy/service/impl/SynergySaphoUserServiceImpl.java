package com.citrix.saphosynergy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citrix.saphosynergy.model.SynergySaphoUser;
import com.citrix.saphosynergy.repository.SynergySaphoUserRepository;

@Service
public class SynergySaphoUserServiceImpl {

	@Autowired
	private SynergySaphoUserRepository userRepository;

	public SynergySaphoUser createUser(SynergySaphoUser user) {
		SynergySaphoUser savedUser = userRepository.save(user);
		System.out.println("User created successfully with ID: " + savedUser.getId());
		return savedUser;
	}

	public List<SynergySaphoUser> getUsers() {
		List<SynergySaphoUser> users = userRepository.findAll();
		System.out.println("Users retrieved successfully..List size: " + users.size());
		return users;
	}
	
	public Optional<SynergySaphoUser> getUserById(Long userId) {
		Optional<SynergySaphoUser> user = userRepository.findById(userId);
		System.out.println("User retrieved successfully.. " + user.get().getId());
		return user;
	}

}
