package org.pt.learn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table ( name="MAGAZINE_PAGE_DEVELOPMENT" )
public class MagazinePageDevelopment {
	
	@Id
	@GeneratedValue
	@Column ( name="PAGE_DEV_ID" )
	private Long pageDevelopmentId;
	
	@Column (name = "NEXT_LINK")
	private Long nextLink;
	
	@Column (name = "PREVOIUS_LINK")
	private Long previousLink;
	
	@OneToOne (mappedBy="development", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private MagPageParagraph magPageParagraph;
	
	@OneToOne (mappedBy="development", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private MagPagePicURL magPagePicURL;
	
	@ManyToOne
	@JoinColumn (name="PAGE_ID")
	private MagazinePage magazinePage;

	public Long getPageDevelopmentId() {
		return pageDevelopmentId;
	}

	public void setPageDevelopmentId(Long pageDevelopmentId) {
		this.pageDevelopmentId = pageDevelopmentId;
	}

	public Long getNextLink() {
		return nextLink;
	}

	public void setNextLink(Long nextLink) {
		this.nextLink = nextLink;
	}

	public Long getPreviousLink() {
		return previousLink;
	}

	public void setPreviousLink(Long previousLink) {
		this.previousLink = previousLink;
	}

	public MagPageParagraph getMagPageParagraph() {
		return magPageParagraph;
	}

	public void setMagPageParagraph(MagPageParagraph magPageParagraph) {
		this.magPageParagraph = magPageParagraph;
	}

	public MagPagePicURL getMagPagePicURL() {
		return magPagePicURL;
	}

	public void setMagPagePicURL(MagPagePicURL magPagePicURL) {
		this.magPagePicURL = magPagePicURL;
	}

	public MagazinePage getMagazinePage() {
		return magazinePage;
	}

	public void setMagazinePage(MagazinePage magazinePage) {
		this.magazinePage = magazinePage;
	}

	@Override
	public String toString() {
		return "MagazinePageDevelopment [pageDevelopmentId="
				+ pageDevelopmentId + ", nextLink=" + nextLink
				+ ", previousLink=" + previousLink + ", magPageParagraph="
				+ magPageParagraph + ", magPagePicURL=" + magPagePicURL
				+ ", magazinePage=" + magazinePage + "]";
	}
	
	
	
	
}
