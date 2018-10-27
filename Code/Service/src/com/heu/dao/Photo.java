package com.heu.dao;

public class Photo {
	private int fun_id;
	private String fun_content;
	private String fun_time;
	private String user_name;
	private String user_head; 
	private int share_count;
	private int comment_count;
	private String photo_name;
	//private String video_name;
	private int user_id;
	private int serise;
	public Photo(int fun_id, String fun_content, String fun_time,
			String user_name,
			String user_head, int comment_count, int praise_count,
			int down_count,int share_count,String sign1, String sign2, String sign3,int serise,String photo_name) {
		super();
		this.fun_id = fun_id;
		this.fun_content = fun_content;
		this.fun_time = fun_time;
		this.user_name = user_name;
		this.sign1 = sign1;
		this.sign2 = sign2;
		this.sign3 = sign3;
		this.user_head = user_head;
		this.comment_count = comment_count;
		this.praise_count = praise_count;
		this.down_count = down_count;
		this.share_count=share_count;
		this.serise=serise;
		this.photo_name=photo_name;
	}
	public String getUser_head() {
		return user_head;
	}
	public void setUser_head(String user_head) {
		this.user_head = user_head;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public int getSerise() {
		return serise;
	}
	public void setSerise(int serise) {
		this.serise = serise;
	}
	public int getFun_id() {
		return fun_id;
	}
	public void setFun_id(int fun_id) {
		this.fun_id = fun_id;
	}
	public String getFun_content() {
		return fun_content;
	}
	public void setFun_content(String fun_content) {
		this.fun_content = fun_content;
	}
	public String getFun_time() {
		return fun_time;
	}
	public void setFun_time(String fun_time) {
		this.fun_time = fun_time;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getShare_count() {
		return share_count;
	}
	public void setShare_count(int share_count) {
		this.share_count = share_count;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getSign1() {
		return sign1;
	}
	public void setSign1(String sign1) {
		this.sign1 = sign1;
	}
	public String getSign2() {
		return sign2;
	}
	public void setSign2(String sign2) {
		this.sign2 = sign2;
	}
	public String getSign3() {
		return sign3;
	}
	public void setSign3(String sign3) {
		this.sign3 = sign3;
	}
	public int getPraise_count() {
		return praise_count;
	}
	public void setPraise_count(int praise_count) {
		this.praise_count = praise_count;
	}
	public int getDown_count() {
		return down_count;
	}
	public void setDown_count(int down_count) {
		this.down_count = down_count;
	}
	private String sign1;
	private String sign2;
	private String sign3;
	private int praise_count;
	private int down_count;
}
