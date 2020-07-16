package com.ahmedeid.securityandjwt.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "previous_job")
public class PreviousJob {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private long code;

	@NotNull
	@Column(name = "pre_school_name")
	private String preSchoolName;

	@NotNull
	@Column(name = "leave_reason")
	private String leaveReason;

	@Column(name = "year_no")
	private int year_NO;
	
	@ManyToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name="previous_job_id",referencedColumnName = "id", nullable=false)
    private User user;

	public PreviousJob() {
		super();
	}

	public PreviousJob(long code, String preSchoolName, String leaveReason, int year_NO) {
		super();
		this.code = code;
		this.preSchoolName = preSchoolName;
		this.leaveReason = leaveReason;
		this.year_NO = year_NO;
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

	public String getPreSchoolName() {
		return preSchoolName;
	}

	public void setPreSchoolName(String preSchoolName) {
		this.preSchoolName = preSchoolName;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public int getYear_NO() {
		return year_NO;
	}

	public void setYear_NO(int year_NO) {
		this.year_NO = year_NO;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PreviousJob [id=" + id + ", code=" + code + ", preSchoolName=" + preSchoolName + ", leaveReason="
				+ leaveReason + ", year_NO=" + year_NO + ", user=" + user + "]";
	}

	

}
