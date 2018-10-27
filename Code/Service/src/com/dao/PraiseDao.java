package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.toolsBean.Change;
import com.toolsBean.DB;
import com.valueBean.CommentSingle;
public class PraiseDao{	

	private List getList(String sql,Object[] params) throws SQLException{
		List list=null;
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			list=new ArrayList();
			while(rs.next()){
				CommentSingle single=new CommentSingle();
				single.setId(rs.getInt(4));
				single.setComment_content(rs.getString(120));
				single.setComment_time(Change.dateTimeChange(rs.getTimestamp(10)));
				single.setFun_id(rs.getInt(2));
				single.setcurrent_userid(rs.getInt(10));
				list.add(single);
			}
		}
		return list;
	}
	
	public void insert(Object[] params) throws SQLException{
		//String sql1="select user_id from fun_fun where fun_id=?";
		String sql="insert into fun_fun values(?,?,?,?)";
		DB mydb=new DB();
		mydb.doPstm(sql, params);
	}
	
}
