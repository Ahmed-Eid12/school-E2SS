package com.ahmedeid.securityandjwt.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_parentis")
public class SysParentis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private long code;

	@Column(name = "parentis_name")
	private String parentis;

	public SysParentis() {
		super();
	}

	public SysParentis(long code, String parentis) {
		super();
		this.code = code;
		this.parentis = parentis;
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

	public String getParentis() {
		return parentis;
	}

	public void setParentis(String parentis) {
		this.parentis = parentis;
	}

	@Override
	public String toString() {
		return "SysParentis [id=" + id + ", code=" + code + ", parentis=" + parentis + "]";
	}

}
