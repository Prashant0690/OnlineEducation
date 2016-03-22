package org.pt.learn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "STUDENT")
public class Student {
	
	@Id
	@GeneratedValue
	@Column (name ="STUDENT_ID")
	private Long studentId;
	
	@Column (name ="STUDENT_SEX")
	private String studentSex;
		
	@Column (name ="STUDENT_PHONE_NO")
	private String studentPhoneNo;
	
	@Column (name ="STUDENT_AUTH_TYPE")
	private String studentAuthType;
	
	@Column (name ="student_VERIFIED")
	private Boolean isStudentAuthenticate;
	
	@OneToOne 
	@JoinColumn (name="USER_ID")
	private Users users;
	
	@ManyToMany (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	 @JoinTable(name = "STUDENT_COURSES",
	   joinColumns = {
	      @JoinColumn(name="STUDENT_ID")           
	    },
	    inverseJoinColumns = {
	      @JoinColumn(name="COURSE_ID")
	    }
	  )
	private List<Course> coursesStudent = new ArrayList<Course>();
	
	


	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public String getStudentSex() {
		return studentSex;
	}


	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}



	public String getStudentPhoneNo() {
		return studentPhoneNo;
	}


	public void setStudentPhoneNo(String studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}


	public String getStudentAuthType() {
		return studentAuthType;
	}


	public void setStudentAuthType(String studentAuthType) {
		this.studentAuthType = studentAuthType;
	}


	public Boolean getIsStudentAuthenticate() {
		return isStudentAuthenticate;
	}


	public void setIsStudentAuthenticate(Boolean isStudentAuthenticate) {
		this.isStudentAuthenticate = isStudentAuthenticate;
	}


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	public List<Course> getCoursesStudent() {
		return coursesStudent;
	}


	public void setCoursesStudent(List<Course> coursesStudent) {
		this.coursesStudent = coursesStudent;
	}
	
	


	
	
	

}
