package org.pt.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="MAG_PIC_URL")
public class MagPagePicURL {
	
	@Id
	@GeneratedValue
	@Column (name="PIC_ID")
	private Long picId;
	
	@Column (name="AFTER_PARA_NO")
	private Integer afterParaNo;
	
	@Column (name="PIC_URL")
	private String picUrl;
	
	@Column (name ="PIC_NAME")
	private String picName;
	
	@OneToOne
	@JoinColumn (name="PAGE_DEV_ID")
	private MagazinePageDevelopment development;

	public Long getPicId() {
		return picId;
	}

	public void setPicId(Long picId) {
		this.picId = picId;
	}

	public Integer getAfterParaNo() {
		return afterParaNo;
	}

	public void setAfterParaNo(Integer afterParaNo) {
		this.afterParaNo = afterParaNo;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public MagazinePageDevelopment getDevelopment() {
		return development;
	}

	public void setDevelopment(MagazinePageDevelopment development) {
		this.development = development;
	}

	@Override
	public String toString() {
		return "MagPagePicURL [picId=" + picId + ", afterParaNo=" + afterParaNo
				+ ", picUrl=" + picUrl + ", picName=" + picName
				+ ", development=" + development + "]";
	}
	
	
	
}
