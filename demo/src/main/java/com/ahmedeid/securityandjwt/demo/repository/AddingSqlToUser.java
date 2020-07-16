package com.ahmedeid.securityandjwt.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ahmedeid.securityandjwt.demo.entities.User;


@Repository
public class AddingSqlToUser {

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
//	public List<User> getByPassword() {
//		
//		Session session = entityManager.unwrap(Session.class);
//		
//		Query<User> userSQL = session.createQuery("from User where password=123456",User.class);
//		
//		List<User> users = userSQL.getResultList();
//		
//		return users;
//		
//	}
	@Transactional
	public Integer updateUserSectionIdInUsers(String userSection , long userCode) {
		Session session = entityManager.unwrap(Session.class);
		
		Query userSQL = session.createQuery("update User u set u.userSection.id= :userSection "
				+ "  where u.code= :userCode " );
		
		userSQL.setParameter("userSection", Integer.parseInt(userSection));
		userSQL.setParameter("userCode", userCode);
		
		int userStatus = userSQL.executeUpdate();
		
		return userStatus;
	}
	
	@Transactional
	public Integer updateUserParentisIdInUsers(int parentisId , long userCode) {
		Session session = entityManager.unwrap(Session.class);
		
		Query userSQL = session.createQuery("update User u set u.userParentis.id= :parentisId "
				+ "  where u.code= :userCode " );
		
		userSQL.setParameter("parentisId", parentisId);
		userSQL.setParameter("userCode", userCode);
		
		int userStatus = userSQL.executeUpdate();
		
		return userStatus;
	}
	
	@Transactional
	public Integer updateUserInfoIdInUsers(int userInfoId , long userCode) {
		Session session = entityManager.unwrap(Session.class);
		
		Query userSQL = session.createQuery("update User u set u.userInformation.id= :userInfoId "
				+ "  where u.code= :userCode " );
		
		userSQL.setParameter("userInfoId", userInfoId);
		userSQL.setParameter("userCode", userCode);
		
		int userStatus = userSQL.executeUpdate();
		
		return userStatus;
	}
	
}
