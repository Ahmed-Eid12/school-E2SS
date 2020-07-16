package com.ahmedeid.securityandjwt.demo.wrapper;

import com.ahmedeid.securityandjwt.demo.entities.UserInformation;
import com.ahmedeid.securityandjwt.demo.uibean.UIUserInformationBean;

public class UIWrapper {

	public static UserInformation userInfoDBToUIUserInfo(UIUserInformationBean userInfoUI) {
		UserInformation userInfo = new UserInformation();
		
		userInfo.setCode(userInfoUI.getCode());
		userInfo.setAddress(userInfoUI.getAddress());
		userInfo.setPhone(userInfoUI.getPhone());
		userInfo.setPreDegree(userInfoUI.getPreDegree());
		userInfo.setCountry(userInfoUI.getCountry());
		userInfo.setCity(userInfoUI.getCity());
		userInfo.setCardId_NO(userInfoUI.getCardId_NO());
		userInfo.setQualification(userInfoUI.getQualification());
		userInfo.setClassName(userInfoUI.getClassName());
		userInfo.setExperienceYear_NO(userInfoUI.getExperienceYear_NO());
		
		return userInfo;
	}

}
