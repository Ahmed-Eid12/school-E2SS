package com.ahmedeid.securityandjwt.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private long code;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private int phone;

	@Column(name = "pre_degree")
	private int preDegree;

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "image")
	private String image;
	
	@Column(name = "card_id")
	private int cardId_NO;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "class_name")
	private String className;
	
	@Column(name = "experience_year_no")
	private int experienceYear_NO;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userInformation")
////	@JoinColumn(name = "user_info_id")
//	private List<User> users;

	public UserInformation() {
		super();
	}

	public UserInformation(long code, String address, int phone, int preDegree, String country, String city,
			String image) {
		super();
		this.code = code;
		this.address = address;
		this.phone = phone;
		this.preDegree = preDegree;
		this.country = country;
		this.city = city;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getPreDegree() {
		return preDegree;
	}

	public void setPreDegree(int preDegree) {
		this.preDegree = preDegree;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

	public int getCardId_NO() {
		return cardId_NO;
	}

	public void setCardId_NO(int cardId_NO) {
		this.cardId_NO = cardId_NO;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getExperienceYear_NO() {
		return experienceYear_NO;
	}

	public void setExperienceYear_NO(int experienceYear_NO) {
		this.experienceYear_NO = experienceYear_NO;
	}

	@Override
	public String toString() {
		return "UserInformation [id=" + id + ", code=" + code + ", address=" + address + ", phone=" + phone
				+ ", preDegree=" + preDegree + ", country=" + country + ", city=" + city + ", image=" + image
				+ ", cardId_NO=" + cardId_NO + ", qualification=" + qualification + ", className=" + className
				+ ", experienceYear_NO=" + experienceYear_NO + ", users="  + "]";
	}


}
