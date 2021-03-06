package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.UserSection;
import com.ahmedeid.securityandjwt.demo.repository.SysParentisRepository;
import com.ahmedeid.securityandjwt.demo.repository.UserSectionRepository;

@Service
public class UserSectionService {
	
	@Autowired
	private UserSectionRepository userSectionRepo;
	
	// find all for user section
	public List<UserSection> findAll() {
		return this.userSectionRepo.findAll();
	}
	
	// add user Section
	public UserSection saveNewSection(UserSection section) {
		return this.userSectionRepo.save(section);
	}
	
	// get user section by id
	public UserSection findUserSectionById(Integer userSectionId) {
		return this.userSectionRepo.findById(userSectionId).get();
	}
	
	// delete user section
	public boolean deleteUserSection(Integer userSectionId) {
		UserSection userSection = findUserSectionById(userSectionId);
		if(userSection != null) {
			this.userSectionRepo.delete(userSection);
			return true;
		}
		return false;
	}

}
