package com.ahmedeid.securityandjwt.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ahmedeid.securityandjwt.demo.entities.PreviousJob;
import com.ahmedeid.securityandjwt.demo.entities.SysParentis;
import com.ahmedeid.securityandjwt.demo.entities.SysPrivelage;
import com.ahmedeid.securityandjwt.demo.entities.User;
import com.ahmedeid.securityandjwt.demo.entities.UserInformation;
import com.ahmedeid.securityandjwt.demo.entities.UserParentis;
import com.ahmedeid.securityandjwt.demo.repository.AddingSqlToUser;
import com.ahmedeid.securityandjwt.demo.security.JwtResponse;
import com.ahmedeid.securityandjwt.demo.security.LoginRequest;
import com.ahmedeid.securityandjwt.demo.security.TokenUtil;
import com.ahmedeid.securityandjwt.demo.services.PreviousJobService;
import com.ahmedeid.securityandjwt.demo.services.UserInformationService;
import com.ahmedeid.securityandjwt.demo.services.UserParentisService;
import com.ahmedeid.securityandjwt.demo.services.UserService;
import com.ahmedeid.securityandjwt.demo.uibean.UIUserInformationBean;
import com.ahmedeid.securityandjwt.demo.uibean.UserUIBean;
import com.ahmedeid.securityandjwt.demo.wrapper.UIWrapper;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
@RequestMapping(value = "/userlogin/auth")
public class AuthController {

	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private UserService userService;

	@Autowired
	private UserParentisService userParentisService;

	@Autowired
	private UserInformationService userInformationService;

	@Autowired
	private PreviousJobService previousJobService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AddingSqlToUser addingSqlToUser;
	
	@Value("${user.image.path}")
	private final String USER_IMAGE = null; 
	
	

	@PostMapping(value = { "", "/" })
	public JwtResponse Login(@RequestBody LoginRequest loginRequest) {
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
		String token = null;
		JwtResponse jwtResponse = null;
		if (userDetails != null) {
			token = tokenUtil.generateToken(userDetails);
			jwtResponse = new JwtResponse(token, "you have a new token", userDetails);
		} else {
			jwtResponse = new JwtResponse(null,
					"username or password invalid, " + "try again later or you can register this login again", null);
		}

		return jwtResponse;
	}

	
	/**
	 * this all methods [ register , saveParentis , saveInformation , savePreJob ]
	 * are for register new user ....
	 * @param userUI
	 * @return
	 */
	@PostMapping(value = "/register")
	public User register(@RequestBody UserUIBean userUI) {

		User newUser = new User();
		newUser.setEmail(userUI.getEmail());
		newUser.setUserName(userUI.getUsername());
		newUser.setPassword(userUI.getPassword());
		newUser.setIsAdmin(0);

		User saveUser = userService.saveUser(newUser);
		return saveUser;

	}

	@PostMapping(value = "/saveNewParentis/{userCode}/{stud_parentis}")
	public UserParentis saveParentis(@RequestBody UserParentis userParentis , 
			@PathVariable String userCode, 
			@PathVariable int stud_parentis) {
		
		UserParentis parentis = new UserParentis();
		SysParentis sysParentis = new SysParentis();
		sysParentis.setId(stud_parentis);
		
		userParentis.setSysParentis(sysParentis);
		parentis = this.userParentisService.saveNewParentis(userParentis);
		
		if(parentis != null) {
			this.addingSqlToUser.updateUserParentisIdInUsers(parentis.getId(), Long.parseLong(userCode));
		}
		
		return parentis;
	}

	@PostMapping(value = "/saveNewUserInfo/{userCode}/{userSection}" )
	public UserInformation saveInformation(
			@RequestParam("userInfo") String userInfoUI,
			@RequestParam("file") MultipartFile file,
			@PathVariable String userCode,@PathVariable String userSection) {
		Gson gson = null;
		UIUserInformationBean userInfoUIBean ;
		UserInformation userInfo = null;
		
		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
//			gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer());
//			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializers());
			
			gson = gsonBuilder.create();
			userInfoUIBean = gson.fromJson(userInfoUI, UIUserInformationBean.class);
			userInfo = new UserInformation();
			userInfo = UIWrapper.userInfoDBToUIUserInfo(userInfoUIBean);
			
			
			
			String fileName = file.getOriginalFilename();
			String extention = fileName.substring(fileName.lastIndexOf("."));
			
			Date date = new Date();
			fileName = userCode + date.getTime() + extention ;
			
			String filePath = USER_IMAGE + "\\" + fileName;
			
			if(filePath != null && !filePath.equals("")) {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
						new File(USER_IMAGE + File.separator + fileName)));
				stream.write(bytes);
				stream.flush();
				stream.close();
			}
			userInfo.setImage(fileName);
			
		}catch(Exception ex ) {
			ex.printStackTrace();
		}
		UserInformation userInfoDB = this.userInformationService.saveNewUserInfo(userInfo);
		
		if(userInfoDB != null) {
			this.addingSqlToUser.updateUserSectionIdInUsers(userSection, Long.parseLong(userCode));
			this.addingSqlToUser.updateUserInfoIdInUsers(userInfo.getId(), Long.parseLong(userCode));
		}
		
		return userInfoDB;
		
	}

	@PostMapping(value = "/saveNewPreviousJob/{userId}")
	public List<PreviousJob> savePreJob(@RequestBody List<PreviousJob> preJob, @PathVariable int userId) {
		List<PreviousJob> listPreviousJob = new ArrayList<PreviousJob>();
		
		for(PreviousJob setUserId: preJob) {
			User user = new User();
			user.setId(userId);
			setUserId.setUser(user);
			listPreviousJob.add(setUserId);
		}
		
		List<PreviousJob> previousJobList = new ArrayList<PreviousJob>();
		previousJobList = this.previousJobService.saveNewPreJobList(listPreviousJob);
		
		return previousJobList;
	}
	
}
