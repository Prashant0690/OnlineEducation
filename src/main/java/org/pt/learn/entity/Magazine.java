package org.pt.learn.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table (name = "MAGAZINE")
public class Magazine {
	
	@Id
	@GeneratedValue
	@Column ( name="MAGAZINE_ID" )
	private Long magazineId;
	
	@Column ( name = "TITLE")
	private String title;
	
	@Column ( name = "OPENING_QUOTE")
	private String openingQuote;
	
	@Column ( name = "COVER_PIC_URL")
	private String coverPicUrl;
	
	@Column ( name = "SCHEDULED")
	private String scheduled;
	
	@Column ( name = "AUTHOR_BIO")
	private String authorBio;
	
	@Temporal (TemporalType.DATE)
	@Column ( name = "DISPATCHED_DATE")
	private Date dispatchedDate;
	
	@Column ( name = "ADVICE_COLUMN")
	private String adviceColumn;
	
	@OneToMany(mappedBy="magazine")
	private List<MagazinePage> magazinePagesList = new ArrayList<MagazinePage>();

	public Long getMagazineId() {
		return magazineId;
	}

	public void setMagazineId(Long magazineId) {
		this.magazineId = magazineId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpeningQuote() {
		return openingQuote;
	}

	public void setOpeningQuote(String openingQuote) {
		this.openingQuote = openingQuote;
	}

	public String getCoverPicUrl() {
		return coverPicUrl;
	}

	public void setCoverPicUrl(String coverPicUrl) {
		this.coverPicUrl = coverPicUrl;
	}

	public String getScheduled() {
		return scheduled;
	}

	public void setScheduled(String scheduled) {
		this.scheduled = scheduled;
	}

	public String getAuthorBio() {
		return authorBio;
	}

	public void setAuthorBio(String authorBio) {
		this.authorBio = authorBio;
	}

	public Date getDispatchedDate() {
		return dispatchedDate;
	}

	public void setDispatchedDate(Date dispatchedDate) {
		this.dispatchedDate = dispatchedDate;
	}

	public String getAdviceColumn() {
		return adviceColumn;
	}

	public void setAdviceColumn(String adviceColumn) {
		this.adviceColumn = adviceColumn;
	}

	public List<MagazinePage> getMagazinePagesList() {
		return magazinePagesList;
	}

	public void setMagazinePagesList(List<MagazinePage> magazinePagesList) {
		this.magazinePagesList = magazinePagesList;
	}

	@Override
	public String toString() {
		return "Magazine [magazineId=" + magazineId + ", title=" + title
				+ ", openingQuote=" + openingQuote + ", coverPicUrl="
				+ coverPicUrl + ", scheduled=" + scheduled + ", authorBio="
				+ authorBio + ", dispatchedDate=" + dispatchedDate
				+ ", adviceColumn=" + adviceColumn + ", magazinePagesList="
				+ magazinePagesList + "]";
	}
	
	

}
