package org.pt.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "GENERAL_RESUME_INFO")
public class GResumeInfo {
	
	@Id
	@GeneratedValue
	@Column (name ="info_ID")
	private Long infoId;
	
	@Column (name="INFO_TYPE")
	private String infoType;
	
	@Column (name="INFO_LINE1")
	private String infoLine1;   
	
	@Column (name="INFO_LINE2")
	private String infoLine2;
	
	@Column (name="INFO_PERIOD")
	private String infoPeriod;
	
	@Column (name="INFO_CONTENT")
	private String infoContent;
	
	@ManyToOne
	@JoinColumn (name="RESUME_ID")
	private GResume generalResume;

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getInfoLine1() {
		return infoLine1;
	}

	public void setInfoLine1(String infoLine1) {
		this.infoLine1 = infoLine1;
	}

	public String getInfoLine2() {
		return infoLine2;
	}

	public void setInfoLine2(String infoLine2) {
		this.infoLine2 = infoLine2;
	}

	public String getInfoPeriod() {
		return infoPeriod;
	}

	public void setInfoPeriod(String infoPeriod) {
		this.infoPeriod = infoPeriod;
	}

	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public GResume getGeneralResume() {
		return generalResume;
	}

	public void setGeneralResume(GResume generalResume) {
		this.generalResume = generalResume;
	}

	@Override
	public String toString() {
		return "GResumeInfo [infoId=" + infoId + ", infoType=" + infoType
				+ ", infoLine1=" + infoLine1 + ", infoLine2=" + infoLine2
				+ ", infoPeriod=" + infoPeriod + ", infoContent=" + infoContent
				+ ", generalResume=" + generalResume + "]";
	}

	
	
}
