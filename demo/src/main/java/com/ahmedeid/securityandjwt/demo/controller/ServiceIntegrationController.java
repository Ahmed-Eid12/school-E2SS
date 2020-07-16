package com.ahmedeid.securityandjwt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.SysParentis;
import com.ahmedeid.securityandjwt.demo.entities.UserSection;
import com.ahmedeid.securityandjwt.demo.services.SysParentisService;
import com.ahmedeid.securityandjwt.demo.services.UserSectionService;

@CrossOrigin
@RestController
@RequestMapping(value="/schoole2ss/integration")
public class ServiceIntegrationController {

	@Autowired
	private UserSectionService userSectionService;
	
	@Autowired
	private SysParentisService sysParentisService;
	
	
	/**
	 * getAllUserSectionList
	 * @return
	 */
	@GetMapping("/getAllUserSectionList")
	public List<UserSection> getAllUserSectionList() {
		return this.userSectionService.findAll();
	}
	
	/**
	 * 
	 * @return
	 * 
	 * getAllSysParentisList
	 */
	@GetMapping("/getAllSysParentisList")
	public List<SysParentis> getAllSysParentisList() {
		return this.sysParentisService.findAll();
	}
	
}
