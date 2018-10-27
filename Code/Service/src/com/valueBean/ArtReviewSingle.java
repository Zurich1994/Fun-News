package com.valueBean;

public class ArtReviewSingle {
	private int id;
	private int artRootId;
	private String artAuthor;
	private String artContent;
	private String artTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public int getArtRootId() {
		return artRootId;
	}
	public void setArtRootId(int artRootId) {
		this.artRootId = artRootId;
	}
	public String getArtAuthor() {
		return artAuthor;
	}
	public void setArtAuthor(String artAuthor) {
		this.artAuthor = artAuthor;
	}
	public String getArtContent() {
		return artContent;
	}
	public void setArtContent(String artContent) {
		this.artContent = artContent;
	}
	public String getArtTime() {
		return artTime;
	}
	public void setArtTime(String artTime) {
		this.artTime = artTime;
	}
}
