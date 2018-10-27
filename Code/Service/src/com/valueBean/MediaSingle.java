package com.valueBean;

public class MediaSingle {
	private int id;
	private int user_id;
	private String mediaTitle;
	private String mediaSrc;
	private String mediaPic;
	private String mediaInfo;
	private String mediaUptime;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public int getMediaWhoId() {
		return user_id;
	}
	public void setMediaWhoId(int mediaWhoId) {
		this.user_id = mediaWhoId;
	}
	public String getMediaTitle() {
		return mediaTitle;
	}
	public String getSubMediaTitle() {
		int len=10;
		if(mediaTitle.length()<=len)
			return mediaTitle;
		else
			return mediaTitle.substring(0,len)+"..";
	}
	public void setMediaTitle(String mediaTitle) {
		this.mediaTitle = mediaTitle;
	}
	public String getMediaSrc() {
		return mediaSrc;
	}
	public void setMediaSrc(String mediaSrc) {
		this.mediaSrc = mediaSrc;
	}
	public String getMediaPic() {
		return mediaPic;
	}
	public void setMediaPic(String mediaPic) {
		this.mediaPic = mediaPic;
	}
	public String getMediaInfo() {
		return mediaInfo;
	}
	public void setMediaInfo(String mediaInfo) {
		this.mediaInfo = mediaInfo;
	}
	public String getMediaUptime() {
		return mediaUptime;
	}
	public void setMediaUptime(String mediaUptime) {
		this.mediaUptime = mediaUptime;
	}
	
}
