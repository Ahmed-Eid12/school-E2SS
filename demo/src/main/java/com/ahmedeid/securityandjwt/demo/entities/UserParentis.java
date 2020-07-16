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

import com.sun.istack.NotNull;

@Entity
@Table(name = "user_parentis")
public class UserParentis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private long code;

	@Column(name = "phone")
	private int phone;

	@Column(name = "parentis_name")
	private String parentisName;

	@Column(name = "parentis_address")
	private String parentisAddress;

	// adding relationship users and userparentis
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sys_parentis_id",referencedColumnName = "id")
	private SysParentis sysParentis;

	public UserParentis() {
	}

	public UserParentis(long code, int phone, String parentisName, String parentisAddress) {
		this.code = code;
		this.phone = phone;
		this.parentisName = parentisName;
		this.parentisAddress = parentisAddress;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getParentisName() {
		return parentisName;
	}

	public void setParentisName(String parentisName) {
		this.parentisName = parentisName;
	}

	public String getParentisAddress() {
		return parentisAddress;
	}

	public void setParentisAddress(String parentisAddress) {
		this.parentisAddress = parentisAddress;
	}

	public SysParentis getSysParentis() {
		return sysParentis;
	}

	public void setSysParentis(SysParentis sysParentis) {
		this.sysParentis = sysParentis;
	}

	@Override
	public String toString() {
		return "UserParentis [id=" + id + ", code=" + code + ", phone=" + phone + ", parentisName=" + parentisName
				+ ", parentisAddress=" + parentisAddress + ", sysParentis=" + sysParentis + "]";
	}

}
