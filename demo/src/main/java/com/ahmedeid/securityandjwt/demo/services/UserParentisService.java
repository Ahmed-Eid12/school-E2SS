package com.ahmedeid.securityandjwt.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.UserParentis;
import com.ahmedeid.securityandjwt.demo.repository.UserParentisRepository;

@Service
public class UserParentisService {

	@Autowired
	private UserParentisRepository userParentisRepository;
	
	public UserParentis saveNewParentis(UserParentis parentis) {
		return this.userParentisRepository.save(parentis);
	}
	
}
