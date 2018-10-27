package com.heu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.heu.common.Dbutils;
import com.heu.dao.Fun;

public class FunServiceImpl {


	public static List<Fun> getList(int user_id,int operate,String time)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String a,b,c,d="";
		int ee=0;
		int f,g,h,p=0;
		int w=0;
		String j,k,o="";
		
		
		List<Fun> list=new ArrayList<Fun>();
		
		try {
			conn=Dbutils.getConnection();
		if(operate==1)//显示全部的段子
		{
			String sql="select t_user_info.User_name,t_user_info.User_image,fun_fun.fun_content,fun_fun.fun_time,fun_fun.fun_id,fun_fun.Praise_count,fun_fun.Down_count,fun_fun.Comment_count,fun_fun.fun_sign1,fun_fun.fun_sign2,fun_fun.fun_sign3,fun_fun.share_count,fun_fun.series from t_user_info,fun_fun where t_user_info.User_id=fun_fun.user_id and series='0' and fun_fun.fun_time<'"+time+"' ORDER BY fun_fun.fun_time DESC,fun_fun.Praise_count+fun_fun.down_count+fun_fun.share_count DESC LIMIT 0,10";
			
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
		}
		else if(operate==2)//显示收藏的段子(带入收藏人的id)
		{
			String sql="select t_user_info.User_name,t_user_info.User_image,fun_fun.fun_content,fun_fun.fun_time,fun_fun.fun_id,fun_fun.Praise_count,fun_fun.Down_count,fun_fun.Comment_count,fun_fun.fun_sign1,fun_fun.fun_sign2,fun_fun.fun_sign3,fun_fun.share_count,fun_fun.series from t_user_info,fun_fun where t_user_info.User_id=fun_fun.user_id and series='0' and fun_fun.fun_time<'"+time+"' ORDER BY fun_fun.fun_time DESC LIMIT 0,10";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
		}
		else//显示好友的段子(带入自己的id)
		{
			String sql="select t_user_info.User_name,t_user_info.User_image,fun_fun.fun_content,fun_fun.fun_time,fun_fun.fun_id,fun_fun.Praise_count,fun_fun.Down_count,fun_fun.Comment_count,fun_fun.fun_sign1,fun_fun.fun_sign2,fun_fun.fun_sign3,fun_fun.share_count from t_user_info,fun_fun,foc_fun where fun_fun.user_id in (select foc_fun.foc_user_id from foc_fun where foc_fun.foc_own_id='"+user_id+"') and t_user_info.User_id =fun_fun.user_id and t_user_info.User_id=foc_fun.foc_user_id and series='0'";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
		}
		while(rs.next())
		{   a=rs.getString(1);
		    b=rs.getString(2);
		    c=rs.getString(3);
		    d=rs.getString(4);
		    ee=rs.getInt(5);
		    f=rs.getInt(6);
		    g=rs.getInt(7);
		    h=rs.getInt(8);
		    j=rs.getString(9);
		    k=rs.getString(10);
		    o=rs.getString(11);
		    w=rs.getInt(12);
		    p=rs.getInt(13);
		    
			System.out.println("用户昵称："+a+"\t"+"用户头像："+b+"\t"+"段子内容： "+c+"\t"+"发布时间："+d+"\t"+"发布段子id："+ee+"\t"+"点赞数量："+f+"\t"+"点差数量："+g+"\t"+"评论数量："+h+"分享数量："+w+"标签1"+j+"\t"+"标签2"+k+"\t"+"标签3"+o);
			list.add(new Fun(ee, c, d, a, b, h,w, f, g,j,k,o,p));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dbutils.closeStatement(pstmt);
		Dbutils.closeConnection();
		return list;
				
	
	
	
	}
	public void insertPraise(int praise_id,String praise_time,int user_id,int fun_id)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=Dbutils.getConnection();
			String sql="insert into t_praise(praise_id,praise_time,praise_user_id,praise_fun_id)values"+
			"('"+praise_id+"','"+praise_time+"','"+user_id+"','"+fun_id+"')";
			pstmt=conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dbutils.closeStatement(pstmt);
		Dbutils.closeConnection();
	}	
public void insertFun(String fun_content,String fun_time,int user_id )
{
	Connection conn=null;
	PreparedStatement pstmt=null;

	try {
		conn=Dbutils.getConnection();
		String sql="insesrt into fun_fun(fun_content,fun_time,user_id)value"+
		"('"+fun_content+"','"+fun_time+"','"+user_id+"')";
		pstmt=conn.prepareStatement(sql);
		pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Dbutils.closeStatement(pstmt);
	Dbutils.closeConnection();
	}


}
