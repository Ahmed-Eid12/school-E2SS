package com.ahmedeid.securityandjwt.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.entities.SysParentis;
import com.ahmedeid.securityandjwt.demo.repository.SysParentisRepository;

@Service
public class SysParentisService {

	@Autowired
	private SysParentisRepository sysParentisRepo;
	
	public List<SysParentis>findAll() {
		return this.sysParentisRepo.findAll();
	}
	
}
