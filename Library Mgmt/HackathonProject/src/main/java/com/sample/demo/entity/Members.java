package com.sample.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Members{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="memberid")
	private int memberId;
	
	@Column(name="membername")
	private String memberName;
	
	public Members() {
		
	}
	
	public Members(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return "Member [Id: " + memberId + ", Name: " + memberName + "]";
	}
}
