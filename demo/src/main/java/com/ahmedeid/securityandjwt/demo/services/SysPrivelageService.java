package com.ahmedeid.securityandjwt.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmedeid.securityandjwt.demo.repository.SysPrivelageRepository;

@Service
public class SysPrivelageService {

	@Autowired
	private SysPrivelageRepository sysPrivelageRepository;
	
}
