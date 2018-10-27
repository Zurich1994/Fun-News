package com.heu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heu.common.Dbutils;
import com.heu.dao.All;
import com.heu.dao.Fun;
import com.heu.dao.Photo;

public class AllServiceImpl {

	public static List<All> getlist(String time,int operate)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String a,b,c,d,ee="";
		int f,g,h,j=0;
		String k,o,p,q,r="";
		int w,x=0;
		
		List<All> list=new ArrayList<All>();
		conn=Dbutils.getConnection();
		
		try {
			if(operate==1)
			{String sql="select t_user_info.User_name,t_user_info.User_image,fun_fun.fun_content,fun_fun.photo_name,fun_fun.video_name,fun_fun.fun_time,fun_fun.fun_id,fun_fun.Praise_count,fun_fun.Down_count,fun_fun.Comment_count,fun_fun.fun_sign1,fun_fun.fun_sign2,fun_fun.fun_sign3,fun_fun.share_count,fun_fun.series,fun_fun.sound_name from t_user_info,fun_fun where t_user_info.user_id=fun_fun.user_id and fun_fun.fun_time<'"+time+"' ORDER BY fun_fun.fun_time DESC,fun_fun.Praise_count+fun_fun.down_count+fun_fun.share_count DESC LIMIT 0,10";
			
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			}
			if(operate==2)
			{
				String sql="select t_user_info.User_name,t_user_info.User_image,fun_fun.fun_content,fun_fun.photo_name,fun_fun.video_name,fun_fun.fun_time,fun_fun.fun_id,fun_fun.Praise_count,fun_fun.Down_count,fun_fun.Comment_count,fun_fun.fun_sign1,fun_fun.fun_sign2,fun_fun.fun_sign3,fun_fun.share_count,fun_fun.series,fun_fun.sound_name from t_user_info,fun_fun where t_user_info.user_id=fun_fun.user_id and fun_fun.fun_time<'"+time+"' ORDER BY fun_fun.fun_time DESC LIMIT 0,10";
				
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
			}
			while(rs.next())
			{   a=rs.getString(1);//user_name
			    b=rs.getString(2);//user_image
			    c=rs.getString(3);//fun_content
			    d=rs.getString(4);//photo_name
			    ee=rs.getString(5);//video_name
			    q=rs.getString(6);//fun_time
			    f=rs.getInt(7);//fun_id
			    g=rs.getInt(8);//praise
			    h=rs.getInt(9);//down
			    j=rs.getInt(10);//comment
			    k=rs.getString(11);//sign1
			    o=rs.getString(12);//sign2
			    p=rs.getString(13);//sign3
			    w=rs.getInt(14);//share
			    x=rs.getInt(15);//series
			    r=rs.getString(16);
			    
				System.out.println("用户昵称："+a+"\t"+"用户头像："+b+"\t"+"段子内容： "+c+"\t"+"发布时间："+q+"\t"+"发布段子id："+f+"\t"+"点赞数量："+g+"\t"+"点差数量："+h+"\t"+"评论数量："+j+"分享数量："+w);
				list.add(new All(f,c,q,a,b,j,g,h,w,k,o,p,x,d,ee,r));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dbutils.closeStatement(pstmt);
		Dbutils.closeConnection();
		return list;
		
	}
	
}
