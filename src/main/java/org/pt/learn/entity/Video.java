package org.pt.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="VIDEO")
public class Video {
	@Id
	@GeneratedValue
	@Column (name="VIDEO_ID")
	private Long  videoId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column (name="ID")
	private String Id;

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
	
	
}
