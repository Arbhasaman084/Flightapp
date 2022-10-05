package com.appointment_ms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_table")
public class PatientUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Name")
	private String firstName;
	
	@Column(name = "Email_id")
	private String emailId;
	
	@Column(name = "Date")
	private String from;
	
	@Column(name = "Time")
	private String timing;
	
	@Column(name = "Speciality")
	private String spec;
	
	@Column(name = "Consultant")
	private String consul;
	
	@Column(name = "Status")
	private String statusap;
	public PatientUser() {
		
	}
	
	public PatientUser(String firstName,String statusap, String emailId, String from, String timing , String spec, String consul) 
	{
		super();
		this.firstName = firstName;
		this.emailId = emailId;
		this.from=from;
		this.timing=timing;
		this.spec=spec;
		this.consul=consul;
		this.statusap=statusap;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
    

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getConsul() {
		return consul;
	}

	public void setConsul(String consul) {
		this.consul = consul;
	}

	public String getStatusap() {
		return statusap;
	}

	public void setStatusap(String statusap) {
		this.statusap = statusap;
	}
	
}
