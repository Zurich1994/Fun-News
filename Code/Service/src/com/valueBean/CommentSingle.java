package com.valueBean;

public class CommentSingle {
	private int Comment_id;
	private int current_userid;
	private int Fun_id;
	private String Comment_content;
	private String Comment_time;
	
	public int getId() {
		return Comment_id;
	}
	public void setId(int Comment_id) {
		this.Comment_id = Comment_id;
	}	
	public int getFun_id() {
		return Fun_id;
	}
	public void setFun_id(int Fun_id) {
		this.Fun_id = Fun_id;
	}
	public int getcurrent_userid() {
		return current_userid;
	}
	public void setcurrent_userid(int current_userid) {
		this.current_userid = current_userid;
	}
	public String getComment_content() {
		return Comment_content;
	}
	public void setComment_content(String Comment_content) {
		this.Comment_content = Comment_content;
	}
	public String getComment_time() {
		return Comment_time;
	}
	public void setComment_time(String Comment_time) {
		this.Comment_time = Comment_time;
	}
}
