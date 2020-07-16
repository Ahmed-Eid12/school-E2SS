package com.ahmedeid.securityandjwt.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ahmedeid.securityandjwt.demo.entities.User;
import com.ahmedeid.securityandjwt.demo.services.UserService;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	
	protected CommonsMultipartResolver commonsMultipartResolver() {
		CommonsMultipartResolver commonsMR = new CommonsMultipartResolver();
		commonsMR.setMaxUploadSize(20971520);
		commonsMR.setMaxInMemorySize(1048576);
		return commonsMR;
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(this.userService.getAll().isEmpty()) {
			System.out.println("LOG:  we will create new user now ");
			User user = new User("ahmed" , "ahmed.radwa@gmail.com" , "123456");
			this.userService.saveUser(user);
			System.out.println("LOG:  you have new user : \n"+user);
		} else {
			System.out.println("LOG: we have found some users in DB");
		}
		
	}

}
