package com.ahmedeid.securityandjwt.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.UserInformation;
import com.ahmedeid.securityandjwt.demo.repository.UserInformationRepository;

@Service
public class UserInformationService {

	@Autowired
	private UserInformationRepository userInformationRepository;
	
	public UserInformation saveNewUserInfo(UserInformation userInfo) {
		return this.userInformationRepository.save(userInfo);
	}
	
}
