package org.pt.learn.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "TEACHER")
public class Teacher {
	
	@Id
	@GeneratedValue
	@Column (name ="TEACHER_ID")
	private Long teacherId;
	
	@Column (name ="TEACHER_UID")
	private String teacherUID;
	
	@Column (name ="TEACHER_PRESENT_WORK")
	private String teachersPresentWork;
	
	@Temporal (TemporalType.DATE)
	@Column (name ="TEACHER_DOB")
	private Date teacherDOB;
	
	@Column (name ="TEACHER_SEX")
	private String teacherSex;
	
	@Column (name ="TEACHER_PERMANENT_ADDRESS")
	private String teacherPermanentAddress;
	
	@Column (name ="TEACHER_CURRENT_ADDRESS")
	private String teacherCurrentAddress;
	
	@Column (name ="TEACHER_EMAIL")
	private String teacherEmail;
	
	@Column (name ="TEACHER_PHONE_NO")
	private String teacherPhoneNo;
	
	@Column (name ="TEACHER_PHOTO_URL")
	private String teacherPhotoURL;
	
	@Column (name ="TEACHER_DOC_URL")
	private String teacherDocURL;
	
	@Column (name ="TEACHER_VERIFIED")
	private Boolean isTeacherAuthenticate;

	@OneToOne 
	@JoinColumn (name="USER_ID")
	private Users users;
	
	@ManyToMany (fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	 @JoinTable(name = "TEACHER_COURSES",
	   joinColumns = {
	      @JoinColumn(name="TEACHER_ID")           
	    },
	    inverseJoinColumns = {
	      @JoinColumn(name="COURSE_ID")
	    }
	  )
	private List<Course> coursesTeacher = new ArrayList<Course>();
	
	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}


	public String getTeacherUID() {
		return teacherUID;
	}

	public void setTeacherUID(String teacherUID) {
		this.teacherUID = teacherUID;
	}

	public String getTeachersPresentWork() {
		return teachersPresentWork;
	}

	public void setTeachersPresentWork(String teachersPresentWork) {
		this.teachersPresentWork = teachersPresentWork;
	}

	

	public Date getTeacherDOB() {
		return teacherDOB;
	}

	public void setTeacherDOB(Date teacherDOB) {
		this.teacherDOB = teacherDOB;
	}

	public String getTeacherSex() {
		return teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	public String getTeacherPermanentAddress() {
		return teacherPermanentAddress;
	}

	public void setTeacherPermanentAddress(String teacherPermanentAddress) {
		this.teacherPermanentAddress = teacherPermanentAddress;
	}

	public String getTeacherCurrentAddress() {
		return teacherCurrentAddress;
	}

	public void setTeacherCurrentAddress(String teacherCurrentAddress) {
		this.teacherCurrentAddress = teacherCurrentAddress;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getTeacherPhoneNo() {
		return teacherPhoneNo;
	}

	public void setTeacherPhoneNo(String teacherPhoneNo) {
		this.teacherPhoneNo = teacherPhoneNo;
	}

	public String getTeacherPhotoURL() {
		return teacherPhotoURL;
	}

	public void setTeacherPhotoURL(String teacherPhotoURL) {
		this.teacherPhotoURL = teacherPhotoURL;
	}

	public String getTeacherDocURL() {
		return teacherDocURL;
	}

	public void setTeacherDocURL(String teacherDocURL) {
		this.teacherDocURL = teacherDocURL;
	}

	public Boolean getIsTeacherAuthenticate() {
		return isTeacherAuthenticate;
	}

	public void setIsTeacherAuthenticate(Boolean isTeacherAuthenticate) {
		this.isTeacherAuthenticate = isTeacherAuthenticate;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Course> getCoursesTeacher() {
		return coursesTeacher;
	}

	public void setCoursesTeacher(List<Course> coursesTeacher) {
		this.coursesTeacher = coursesTeacher;
	}
	
	
	

}
