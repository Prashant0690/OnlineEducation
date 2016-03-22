package org.pt.learn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table (name="USERS")
public class Users {
	
	@Id
	@GeneratedValue
	@Column (name ="USER_ID")
	private Long userId;
	
	@Column (name ="USER_NAME")
	@Size (min = 6 , message="Should be atleast 6 character long and unique")
	/*@UniqueUsername (message="This user name already exists")*/
	private String userName;
	
	@Column (name ="USER_EMAIL")
	@NotEmpty
	@Email
	private String userEmail;
	
	@Column (name ="password")
	@Size (min = 6 , message="Should be atleast 6 character long")
	private String password;
	
	@Column (name ="USER_ENABLED")
	private Boolean userEnabled;
	
	@Column (name ="USER_TYPE")
	private String userType;
	
	@Column (name ="FACEBOOK")
	private String facebook;
	
	@Column (name ="GMAIL")
	private String gmail;
	
	@Column (name = "PHONE_VERIFIED")
	private Boolean phoneVerified;
	
	@Temporal (TemporalType.DATE)
	@Column (name ="DATE_CREATED")
	private Date dateCreater;
	
	@Temporal (TemporalType.DATE)
	@Column (name ="DATE_UPDATED")
	private Date dateUpdated;
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name ="LAST_LOGIN")
	private Date lastLogin;
	
	  // mapping owner
/*	  @ManyToMany
	  @JoinTable(name = "USER_COURSES",
	    joinColumns = {
	      @JoinColumn(name="USER_ID")           
	    },
	    inverseJoinColumns = {
	      @JoinColumn(name="COURSE_ID")
	    }
	  )
	private List<Course> courses = new ArrayList<Course>();*/
	
	/*@ManyToMany
	@JoinTable(name = "USERS_ROLES",
	    joinColumns = {
	      @JoinColumn(name="USER_ID")           
	    },
	    inverseJoinColumns = {
	      @JoinColumn(name="ROLE_ID")
	    }
	 )
	private List<Roles> roles = new ArrayList<Roles>();*/

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(Boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public Boolean getPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(Boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public Date getDateCreater() {
		return dateCreater;
	}

	public void setDateCreater(Date dateCreater) {
		this.dateCreater = dateCreater;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}	

}
