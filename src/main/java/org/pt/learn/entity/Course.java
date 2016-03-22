package org.pt.learn.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table ( name = "COURSE")
public class Course {
	
	@Id
	@GeneratedValue
	@Column (name = "COURSE_ID")
	private Long courseId;
	
	@Column (name = "COURSE_UID" , nullable=false)
	@Size (min = 6 , message="Should be atleast 6 character long")
	private String courseUID;
	
	@Column (name="COURSE_TYPE_ID", nullable=false,unique=true)
	private Long courseTypeId;
	
	@Column (name = "LATEST_UPDATE_ID")
	private Long latestUpdateId;
	
	@Column (name = "COURSE_NAME")
	@NotEmpty
	@Size (min = 6 , message="Should be atleast 6 character long")
	private String courseName;
	
	@Column (name = "COURSE_SHORT_DISCRIPTION")
	@Size (min = 20 , message="Should be atleast 6 character long")
	private String courseShortDiscription;
	
	@Temporal (TemporalType.DATE)
	@Column (name = "COURSE_REG_DATE")
	private Date courseRegDate;
	
	@Temporal (TemporalType.DATE)
	@Column (name = "COURSE_START_DATE")
	@DateTimeFormat (pattern="yyyy/dd/mm", style="Should be in form yyyy/dd/mm ")
	private Date courseStartDate;
	
	@Temporal (TemporalType.DATE)
	@Column (name = "COURSE_END_DATE")
	@DateTimeFormat (pattern="yyyy/dd/mm")
	private Date courseEndDate;
	
	@Column (name = "COURSE_ROOM")
	private Integer courseRoom;
	
	@Column (name = "COURSE_VERIFIED")
	private Boolean courseVerified;
	
	@Column (name="COURSE_SUBJECT")
	@NotBlank
	private String courseSubject;
	
	@Column (name="COURSE_TYPE")
	private String courseType;
	
	@Column (name="COURSE_CATEGORY")
	private String courseCategory;
	
	@ManyToMany (mappedBy = "coursesStudent")
	private List<Student> students = new ArrayList<Student>();
	
	@ManyToMany (mappedBy="coursesTeacher")
	private List<Teacher> teachers = new ArrayList<Teacher>();
	
	@OneToMany(mappedBy="course")
	private List<CourseDescription> descriptionsList = new ArrayList<CourseDescription>();

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseUID() {
		return courseUID;
	}

	public void setCourseUID(String courseUID) {
		this.courseUID = courseUID;
	}

	public Long getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(Long courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public Long getLatestUpdateId() {
		return latestUpdateId;
	}

	public void setLatestUpdateId(Long latestUpdateId) {
		this.latestUpdateId = latestUpdateId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseShortDiscription() {
		return courseShortDiscription;
	}

	public void setCourseShortDiscription(String courseShortDiscription) {
		this.courseShortDiscription = courseShortDiscription;
	}

	public Date getCourseRegDate() {
		return courseRegDate;
	}

	public void setCourseRegDate(Date courseRegDate) {
		this.courseRegDate = courseRegDate;
	}

	public Date getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public Date getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public Integer getCourseRoom() {
		return courseRoom;
	}

	public void setCourseRoom(Integer courseRoom) {
		this.courseRoom = courseRoom;
	}

	public Boolean getCourseVerified() {
		return courseVerified;
	}

	public void setCourseVerified(Boolean courseVerified) {
		this.courseVerified = courseVerified;
	}

	public String getCourseSubject() {
		return courseSubject;
	}

	public void setCourseSubject(String courseSubject) {
		this.courseSubject = courseSubject;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<CourseDescription> getDescriptionsList() {
		return descriptionsList;
	}

	public void setDescriptionsList(List<CourseDescription> descriptionsList) {
		this.descriptionsList = descriptionsList;
	}

	/*public String modelDisplay() {
		return "Course [courseId=" + courseId + ",<br> courseUID=" + courseUID
				+ ",<br> courseTypeId=" + courseTypeId + ",<br> courseName="
				+ courseName + ",<br> courseShortDiscription="
				+ courseShortDiscription + ",<br> courseRegDate=" + courseRegDate
				+ ",<br> courseStartDate=" + courseStartDate + ",<br> courseEndDate="
				+ courseEndDate + ",<br> courseRoom=" + courseRoom
				+ ",<br> courseVerified=" + courseVerified + ",<br> courseSubject="
				+ courseSubject + ",<br> courseType=" + courseType
				+ ",<br> courseCategory=" + courseCategory +"]";
	}
*/
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseUID=" + courseUID
				+ ", courseTypeId=" + courseTypeId + ", courseName="
				+ courseName + ", courseShortDiscription="
				+ courseShortDiscription + ", courseRegDate=" + courseRegDate
				+ ", courseStartDate=" + courseStartDate + ", courseEndDate="
				+ courseEndDate + ", courseRoom=" + courseRoom
				+ ", courseVerified=" + courseVerified + ", courseSubject="
				+ courseSubject + ", courseType=" + courseType
				+ ", courseCategory=" + courseCategory + ", students="
				+ students + ", teachers=" + teachers + ", descriptionsList="
				+ descriptionsList + "]";
	}
	
	
	
}
