package org.pt.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="COURSE_DESCRIPTION")
public class CourseDescription {
	
	@Id
	@GeneratedValue
	@Column (name = "DESC_ID")
	private Long descriptionId;
	
	@Column (name = "DESC_TYPE")
	private String descType;
	
	@Column (name="DESC_NO")
	private Integer descNo;
	
	@Column (name = "DESC_STRING")
	@Lob
	private String descString;
	
	@ManyToOne
	@JoinColumn (name="COURSE_ID")
	private Course course;

	public Long getDescriptionId() {
		return descriptionId;
	}

	public void setDescriptionId(Long descriptionId) {
		this.descriptionId = descriptionId;
	}

	public String getDescType() {
		return descType;
	}

	public void setDescType(String descType) {
		this.descType = descType;
	}

	public Integer getDescNo() {
		return descNo;
	}

	public void setDescNo(Integer descNo) {
		this.descNo = descNo;
	}

	public String getDescString() {
		return descString;
	}

	public void setDescString(String descString) {
		this.descString = descString;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
