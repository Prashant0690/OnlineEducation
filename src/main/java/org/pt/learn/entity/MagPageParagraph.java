package org.pt.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="MAG_PAGE_PARAGRAPH")
public class MagPageParagraph {
	
	@Id
	@GeneratedValue
	@Column (name="PARA_ID")
	private Long paraId;
	
	@Column (name="PARA_NO")
	private Integer paraNo;
	
	@Column (name="PARA_CONTENT")
	@Lob
	private String paraContent;
	
	@OneToOne
	@JoinColumn (name="PAGE_DEV_ID")
	private MagazinePageDevelopment development;

	public Long getParaId() {
		return paraId;
	}

	public void setParaId(Long paraId) {
		this.paraId = paraId;
	}

	public Integer getParaNo() {
		return paraNo;
	}

	public void setParaNo(Integer paraNo) {
		this.paraNo = paraNo;
	}

	public String getParaContent() {
		return paraContent;
	}

	public void setParaContent(String paraContent) {
		this.paraContent = paraContent;
	}

	public MagazinePageDevelopment getDevelopment() {
		return development;
	}

	public void setDevelopment(MagazinePageDevelopment development) {
		this.development = development;
	}

	@Override
	public String toString() {
		return "MagPageParagraph [paraId=" + paraId + ", paraNo=" + paraNo
				+ ", paraContent=" + paraContent + ", development="
				+ development + "]";
	}
	
	
	
}
