package org.pt.learn.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table ( name="MAGAZINE_PAGE" )
public class MagazinePage {
	
	@Id
	@GeneratedValue
	@Column ( name="PAGE_ID" )
	private Long pageId;
	
	@Column ( name="PAGE_TITLE" )
	private String pageTitle;
	
	@Column ( name="PAGE_SUB_TITLE" )
	private String pageSubTitle;
	
	@Column ( name = "PAGE_QUOTE")
	private String pageQuote;
	
	@Temporal(TemporalType.DATE)
	@Column ( name="GO_ONLINE_DATE" )
	private Date goOnlineDate;
	
	@Column ( name="PAGE_NO" )
	private Integer pageNo;
	
	@Column ( name="VIDEO_URL" )
	private String videoUrl;
	
	@Column ( name="PAGE_PIC_URL" )
	private String pagePicUrl;
	
	@Column ( name="CONTRIBUTION")
	private String contribution;
	
	@Column (name="PARA_HEAD")
	private Long paraHead;
	
	@Column (name="ADD_QUIZ")
	private boolean addQuiz;
	
	@OneToMany (mappedBy="magazinePage")
	private List<MagazinePageDevelopment> magazinePageDevelopment = new ArrayList<MagazinePageDevelopment>();
	
	@ManyToOne
	@JoinColumn (name="MAGAZINE_ID")
	private Magazine magazine;

	public Long getPageId() {
		return pageId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageSubTitle() {
		return pageSubTitle;
	}

	public void setPageSubTitle(String pageSubTitle) {
		this.pageSubTitle = pageSubTitle;
	}

	public String getPageQuote() {
		return pageQuote;
	}

	public void setPageQuote(String pageQuote) {
		this.pageQuote = pageQuote;
	}

	public Date getGoOnlineDate() {
		return goOnlineDate;
	}

	public void setGoOnlineDate(Date goOnlineDate) {
		this.goOnlineDate = goOnlineDate;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getPagePicUrl() {
		return pagePicUrl;
	}

	public void setPagePicUrl(String pagePicUrl) {
		this.pagePicUrl = pagePicUrl;
	}

	public String getContribution() {
		return contribution;
	}

	public void setContribution(String contribution) {
		this.contribution = contribution;
	}

	public List<MagazinePageDevelopment> getMagazinePageDevelopment() {
		return magazinePageDevelopment;
	}

	public void setMagazinePageDevelopment(
			List<MagazinePageDevelopment> magazinePageDevelopment) {
		this.magazinePageDevelopment = magazinePageDevelopment;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public Long getParaHead() {
		return paraHead;
	}

	public void setParaHead(Long paraHead) {
		this.paraHead = paraHead;
	}

	
	public boolean getAddQuiz() {
		return addQuiz;
	}

	public void setAddQuiz(boolean addQuiz) {
		this.addQuiz = addQuiz;
	}

	@Override
	public String toString() {
		return "MagazinePage [pageId=" + pageId + ", pageTitle=" + pageTitle
				+ ", pageSubTitle=" + pageSubTitle + ", pageQuote=" + pageQuote
				+ ", goOnlineDate=" + goOnlineDate + ", pageNo=" + pageNo
				+ ", videoUrl=" + videoUrl + ", pagePicUrl=" + pagePicUrl
				+ ", contribution=" + contribution + ", paraHead=" + paraHead
				+ ", addQuiz=" + addQuiz + ", magazinePageDevelopment="
				+ magazinePageDevelopment + ", magazine=" + magazine + "]";
	}

	

	
}
