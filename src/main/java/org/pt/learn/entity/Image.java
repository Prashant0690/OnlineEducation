package org.pt.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="IMAGES")
public class Image {
	@Id
	@GeneratedValue
	@Column (name="IMAGE_ID")
	private Long  imageId;
	
	@Column(name="IMG_DESCRIBTION")
	private String imageDescription;
	
	@Column (name="IMG_URL")
	private String imgUrl;
	
	

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}
	

}
