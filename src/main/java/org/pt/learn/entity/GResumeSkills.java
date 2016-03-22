package org.pt.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "GENERAL_RESUME_SKILLS")
public class GResumeSkills {
	
	@Id
	@GeneratedValue
	@Column (name ="SKILLS_ID")
	private Long skillsId;
	
	@Column (name="SKILL_TYPE")
	private String skillType;
	
	@Column (name="SKILL_LEVEL")
	private int skillLevel;
	
	@ManyToOne
	@JoinColumn (name="RESUME_ID")
	private GResume generalResume;

	public Long getSkillsId() {
		return skillsId;
	}

	public void setSkillsId(Long skillsId) {
		this.skillsId = skillsId;
	}

	public String getSkillType() {
		return skillType;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public GResume getGeneralResume() {
		return generalResume;
	}

	public void setGeneralResume(GResume generalResume) {
		this.generalResume = generalResume;
	}

	@Override
	public String toString() {
		return "GResumeSkills [skillsId=" + skillsId + ", skillType="
				+ skillType + ", skillLevel=" + skillLevel + ", generalResume="
				+ generalResume + "]";
	}
	

}
