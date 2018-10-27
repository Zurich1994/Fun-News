package com.valueBean;

public class UserSingle {
	private int user_id;
	private String user_Name;
	private String user_Password;
	private String user_Sex;
	private String user_Register;
	private String user_Info;
	
	public UserSingle(){
		user_Name="";
		user_Password="";
		user_Sex="";
		user_Info="";
	}
	
	public int getId() {
		return user_id;
	}
	public void setId(int user_id) {
		this.user_id = user_id;
	}
	public String getUserName() {
		return user_Name;
	}
	public void setUserName(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getUserPassword() {
		return user_Password;
	}
	public void setUserPassword(String user_Password) {
		this.user_Password = user_Password;
	}	
	
	public String getUserSex() {
		return user_Sex;
	}
	public void setUserSex(String user_Sex) {
		this.user_Sex = user_Sex;
	}
	public String getUserInfo() {
		return user_Info;
	}
	public void setUserInfo(String user_Info) {
		this.user_Info = user_Info;
	}

	public String getUserCTTime() {
		return user_Register;
	}
	public void setUserCTTime(String user_Register) {
		this.user_Register = user_Register;
	}
	
}
