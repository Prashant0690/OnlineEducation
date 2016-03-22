package org.pt.learn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table ( name = "COURSE_UPDATES")
public class CourseUpdates {
	
	@Id
	@GeneratedValue
	@Column (name = "UPDATE_ID")
	private Long updateId;
	
	@Column (name = "UPDATE_TITLE")
	private String updateTitle;
	
	@Column (name = "UPDATE_MESSAGE")
	@Lob
	private String updateMessage;
	
	@Column (name = "UPDATE_DATE")
	@Temporal (TemporalType.DATE)
	private Date updateDate;
	
	@Column (name="DO_UPDATE")
	private boolean doUpdate= false;
	
	@Column (name="COURSE_ID")
	private Long courseId;

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public String getUpdateTitle() {
		return updateTitle;
	}

	public void setUpdateTitle(String updateTitle) {
		this.updateTitle = updateTitle;
	}

	public String getUpdateMessage() {
		return updateMessage;
	}

	public void setUpdateMessage(String updateMessage) {
		this.updateMessage = updateMessage;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean getDoUpdate() {
		return doUpdate;
	}

	public void setDoUpdate(boolean doUpdate) {
		this.doUpdate = doUpdate;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
		
}
