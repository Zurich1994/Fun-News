package com.valueBean;

public class PraiseSingle {
	private int Praise_id;
	private int Priase_user_id;
	private int Fun_id;
	private String Praise_type;
	private String Praise_time;
	
	public int getId() {
		return Praise_id;
	}
	public void setId(int Praise_id) {
		this.Praise_id = Praise_id;
	}	
	public int getFun_id() {
		return Fun_id;
	}
	public void setFun_id(int Fun_id) {
		this.Fun_id = Fun_id;
	}
	public int getPriase_user_id() {
		return Priase_user_id;
	}
	public void setPriase_user_id(int Priase_user_id) {
		this.Priase_user_id = Priase_user_id;
	}
	public String getPraise_type() {
		return Praise_type;
	}
	public void setPraise_type(String Praise_type) {
		this.Praise_type = Praise_type;
	}
	public String getPraise_time() {
		return Praise_time;
	}
	public void setPraise_time(String Praise_time) {
		this.Praise_time = Praise_time;
	}
}
