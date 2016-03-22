package org.pt.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name="ADMIN")
public class Admin {
	
	@Id
	@GeneratedValue
	@Column (name="ADMIN_ID")
	private Long adminId;
	
	@Column (name="ADMIN_TYPE")
	private String adminType;
	
	@OneToOne 
	@JoinColumn (name="USER_ID")
	private Users users;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminType() {
		return adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	

}
