package com.heu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.heu.common.Dbutils;

public class UserDaoImpl {
	
public boolean isTure(String account,String password)
{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	boolean flag=true;

	
	try {
		conn=Dbutils.getConnection();
		String sql="select * from t_user_info where t_user_info.User_account='"+account+"'and t_user_info.User_password='"+password+"'";
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			return flag;
		}
		else
		{
			return flag=false;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Dbutils.closeStatement(pstmt);
	Dbutils.closeConnection();
	return flag;

	}

public boolean register(String name,String password,String account)
{
	boolean b=false;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int i = 0;
	
	try {
		conn=Dbutils.getConnection();
		String sql="insert into t_user_info(user_name,user_password,user_account)values(?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setString(2, password);
		pstmt.setString(3,account);
		i=pstmt.executeUpdate();
		if (i>0)
		{
			b=true;
		}
		else
		{
			b=false;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return b;
	
}
	}

//4.¹Ø±ÕÊý¾Ý¿â
		/*Dbutils.closeStatement(pstmt);
		Dbutils.closeConnection();*/