package com.heu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heu.common.Dbutils;
import com.heu.dao.Sound;


public class SoundServiceImpl {
	public static List<Sound> getList(int user_id,int operate,String time)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String a,b,c,d,ee="";
		
		int f,g,h=0;
		int w,j,x=0;
		
		String k,o,p,q="";
		
		
		List<Sound> list=new ArrayList<Sound>();
		
		try {
			conn=Dbutils.getConnection();
		if(operate==1)//��ʾȫ����ͼƬ
		{
			String sql="select t_user_info.User_name,t_user_info.User_image,fun_fun.fun_content,fun_fun.sound_name,fun_fun.fun_time,fun_fun.fun_id,fun_fun.Praise_count,fun_fun.Down_count,fun_fun.Comment_count,fun_fun.fun_sign1,fun_fun.fun_sign2,fun_fun.fun_sign3,fun_fun.share_count,fun_fun.series,fun_fun.photo_name from t_user_info,fun_fun where t_user_info.User_id=fun_fun.user_id and series in(5,6) and fun_fun.fun_time<'"+time+"' ORDER BY fun_fun.fun_time DESC,fun_fun.Praise_count+fun_fun.down_count+fun_fun.share_count DESC LIMIT 0,10";
			
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
		}
		else if(operate==2)//��ʾ�ղص�ͼƬ(�����ղ��˵�id)
		{
			String sql="select t_user_info.User_name,t_user_info.User_image,fun_fun.fun_content,fun_fun.sound_name,fun_fun.fun_time,fun_fun.fun_id,fun_fun.Praise_count,fun_fun.Down_count,fun_fun.Comment_count,fun_fun.fun_sign1,fun_fun.fun_sign2,fun_fun.fun_sign3,fun_fun.share_count,fun_fun.series,fun_fun.photo_name from t_user_info,fun_fun where t_user_info.User_id=fun_fun.user_id and series in(5,6) and fun_fun.fun_time<'"+time+"' ORDER BY fun_fun.fun_time DESC LIMIT 0,10";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
		}
		else//��ʾ���ѵĶ���(�����Լ���id)
		{
			String sql="select t_user_info.User_name,t_user_info.User_image,fun_fun.fun_content,fun_fun.video_name,fun_fun.fun_time,fun_fun.fun_id,fun_fun.Praise_count,fun_fun.Down_count,fun_fun.Comment_count,fun_fun.fun_sign1,fun_fun.fun_sign2,fun_fun.fun_sign3,fun_fun.share_count,fun_fun.series from t_user_info,fun_fun,foc_fun where fun_fun.user_id in (select foc_fun.foc_user_id from foc_fun where foc_fun.foc_own_id='"+user_id+"') and t_user_info.User_id =fun_fun.user_id and t_user_info.User_id=foc_fun.foc_user_id and series='4' or series='3'";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
		}
		while(rs.next())
		{   a=rs.getString(1);
		    b=rs.getString(2);
		    c=rs.getString(3);
		    d=rs.getString(4);
		    ee=rs.getString(5);
		    f=rs.getInt(6);
		    g=rs.getInt(7);
		    h=rs.getInt(8);
		    j=rs.getInt(9);
		    k=rs.getString(10);
		    o=rs.getString(11);
		    p=rs.getString(12);
		    w=rs.getInt(13);
		    x=rs.getInt(14);
		    q=rs.getString(15);
		    
			System.out.println("�û��ǳƣ�"+a+"\t"+"�û�ͷ��"+b+"\t"+"�������ݣ� "+c+"\t"+"����ʱ�䣺"+d+"\t"+"��������id��"+ee+"\t"+"����������"+f+"\t"+"���������"+g+"\t"+"����������"+h+"����������"+w+"��ǩ1"+j+"\t"+"��ǩ2"+k+"\t"+"��ǩ3"+o);
			list.add(new Sound(f,c,ee,a,b,j,g,h,w,k,o,p,x,d,q));
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
