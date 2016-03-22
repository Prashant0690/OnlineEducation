package org.pt.learn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "GENERAL_RESUME")
public class GResume {
	
	@Id
	@GeneratedValue
	@Column (name ="RESUME_ID")
	private Long resumeId;
	
	@Column (name="USER_ID", nullable=false, unique=true)
	private String resumeUserId;
	
	@Column (name="YOUR_NAME")
	private String yourName;
	
	@Column (name="YOUR_OPENING_CMT")
	private String yourOpeningCmt;
	
	@Column (name="ABOUT_ME")
	@Lob
	private String aboutMe;
	
	@Column (name="ABOUT_EDUCATION")
	@Lob
	private String aboutEducation;
	
	@Column (name="ABOUT_WORK")
	@Lob
	private String aboutWork;
	
	@Column (name="ABOUT_SKILLS")
	@Lob
	private String aboutSkills;
	
	@Column (name="QUOTE")
	private String famousQuote;
	
	@Column (name="QUOTE_BY")
	private String quoteBy;
	
	@Column (name="CONTACT_ME")
	private String contactMe;   // add line 1, add line 2, add line 3, ph, email.
	
	@OneToMany(mappedBy="generalResume", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<GResumeInfo> resumeInfoList = new ArrayList<GResumeInfo>();
	
	@OneToMany (mappedBy="generalResume", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<GResumeSkills> resumeSkillList = new ArrayList<GResumeSkills>();

	public Long getResumeId() {
		return resumeId;
	}

	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}

	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public String getResumeUserId() {
		return resumeUserId;
	}

	public void setResumeUserId(String resumeUserId) {
		this.resumeUserId = resumeUserId;
	}

	public String getYourOpeningCmt() {
		return yourOpeningCmt;
	}

	public void setYourOpeningCmt(String yourOpeningCmt) {
		this.yourOpeningCmt = yourOpeningCmt;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getAboutEducation() {
		return aboutEducation;
	}

	public void setAboutEducation(String aboutEducation) {
		this.aboutEducation = aboutEducation;
	}

	public String getAboutWork() {
		return aboutWork;
	}

	public void setAboutWork(String aboutWork) {
		this.aboutWork = aboutWork;
	}

	public String getAboutSkills() {
		return aboutSkills;
	}

	public void setAboutSkills(String aboutSkills) {
		this.aboutSkills = aboutSkills;
	}

	public String getFamousQuote() {
		return famousQuote;
	}

	public void setFamousQuote(String famousQuote) {
		this.famousQuote = famousQuote;
	}

	public String getQuoteBy() {
		return quoteBy;
	}

	public void setQuoteBy(String quoteBy) {
		this.quoteBy = quoteBy;
	}

	public String getContactMe() {
		return contactMe;
	}

	public void setContactMe(String contactMe) {
		this.contactMe = contactMe;
	}

	public List<GResumeInfo> getResumeInfoList() {
		return resumeInfoList;
	}

	public void setResumeInfoList(List<GResumeInfo> resumeInfoList) {
		this.resumeInfoList = resumeInfoList;
	}

	public List<GResumeSkills> getResumeSkillList() {
		return resumeSkillList;
	}

	public void setResumeSkillList(List<GResumeSkills> resumeSkillList) {
		this.resumeSkillList = resumeSkillList;
	}

	@Override
	public String toString() {
		return "GResume [resumeId=" + resumeId + ", yourName=" + yourName
				+ ", yourOpeningCmt=" + yourOpeningCmt + ", aboutMe=" + aboutMe
				+ ", aboutEducation=" + aboutEducation + ", aboutWork="
				+ aboutWork + ", aboutSkills=" + aboutSkills + ", famousQuote="
				+ famousQuote + ", quoteBy=" + quoteBy + ", contactMe="
				+ contactMe + "]";
	}

	
	

}
