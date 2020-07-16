package com.ahmedeid.securityandjwt.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_section")
public class UserSection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private long code;

	@Column(name = "section_name")
	private String sction;

	public UserSection() {
	}

	public UserSection(long code, String sction) {
		this.code = code;
		this.sction = sction;
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

	public String getSction() {
		return sction;
	}

	public void setSction(String sction) {
		this.sction = sction;
	}

	@Override
	public String toString() {
		return "UserSection [id=" + id + ", code=" + code + ", sction=" + sction + "]";
	}

}
