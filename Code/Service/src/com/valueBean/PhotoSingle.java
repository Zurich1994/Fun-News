package com.valueBean;

public class PhotoSingle {
	private int photo_id;
	private int user_id;
	private String photoSrc;
	private String photoInfo;
	private String photoUptime;
	
	public int getId() {
		return photo_id;
	}
	public void setId(int user_id) {
		this.user_id = user_id;
	}	
	public int getPhotoWhoId() {
		return user_id;
	}
	public void setPhotoWhoId(int user_id) {
		this.user_id = user_id;
	}
	public String getPhotoSrc() {
		return photoSrc;
	}
	public void setPhotoSrc(String photoSrc) {
		this.photoSrc = photoSrc;
	}
	public String getPhotoInfo() {
		return photoInfo;
	}
	public String getSubPhotoInfo() {
		int len=9;
		if(photoInfo.length()<=len)
			return photoInfo;
		else
			return photoInfo.substring(0,len)+"...";
	}
	public void setPhotoInfo(String photoInfo) {
		this.photoInfo = photoInfo;
	}
	public String getPhotoUptime() {
		return photoUptime;
	}
	public void setPhotoUptime(String photoUptime) {
		this.photoUptime = photoUptime;
	}
}