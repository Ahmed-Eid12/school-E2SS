package com.ahmedeid.securityandjwt.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.PreviousJob;
import com.ahmedeid.securityandjwt.demo.entities.User;
import com.ahmedeid.securityandjwt.demo.entities.UserSection;
import com.ahmedeid.securityandjwt.demo.repository.AddingSqlToUser;
import com.ahmedeid.securityandjwt.demo.services.UserSectionService;
import com.ahmedeid.securityandjwt.demo.uibean.UserUIBean;

@CrossOrigin
@RestController
@RequestMapping(value="/schoole2ss/adminintegration")
public class AdminIntegrationController {
	
	@Autowired
	private AddingSqlToUser handSQL;
	
	@Autowired
	private UserSectionService userSectionService;
	
	@GetMapping(value = "/userHaveNoInfo")
	public List<User> userHaveNoInfo() {
		List<User> users = this.handSQL.usersHaveNoInfo();
		return users;
	}
	
	@GetMapping(value = "/countCserHaveNoInfo")
	public Long countCserHaveNoInfo() {
		Long usersCount = this.handSQL.countUsersHaveNoInfo();
		return usersCount;
	}
	
	// all about user section add ,update ,get ,delete
	
	/**+
	 * first add user section
	 * saveNewUserSection()
	 * 
	 * @param userSection @RequestBody
	 */
	@PostMapping(value = "/saveNewUserSection")
	public UserSection saveNewUserSection(@RequestBody UserSection userSection) {
		System.out.println(userSection);
		return this.userSectionService.saveNewSection(userSection);
	}
	
	/**+
	 * 
	 * updateNewUserSection()
	 * 
	 * @param userSection @RequestBody
	 * @param userSectionId
	 */
	@PutMapping(value = "/updateNewUserSection/{userSectionId}")
	public UserSection updateNewUserSection(@PathVariable int userSectionId
			,@RequestBody UserSection userSection) {
		UserSection getUserSection = this.userSectionService.findUserSectionById(userSectionId);
		
		if(getUserSection != null && ( getUserSection.getId() == userSection.getId() )) {
			return this.userSectionService.saveNewSection(userSection);	
		}
		return null;
	}
	
	/**
	 * 
	 * get all user sections
	 * 
	 * getAllUserSections()
	 */
	@GetMapping(value = "/getAllUserSections")
	public List<UserSection> getAllUserSections() {
		return this.userSectionService.findAll();
	}
	
	/**
	 * 
	 * get user section by id
	 * getUserSectionById()
	 * 
	 * @param userSectionId
	 */
	@GetMapping(value = "/getUserSectionById/{userSectionId}")
	public UserSection getUserSectionById(@PathVariable int userSectionId) {
		return this.userSectionService.findUserSectionById(userSectionId);
	}
	
	/**
	 * 
	 * delete user section by id
	 * 
	 * deleteUserSection()
	 * @param userSectionId
	 */
	@DeleteMapping(value = "/deleteUserSectionById/{userSectionId}")
	public  boolean deleteUserSection(@PathVariable int userSectionId) {
		return this.userSectionService.deleteUserSection(userSectionId);
	}

}
