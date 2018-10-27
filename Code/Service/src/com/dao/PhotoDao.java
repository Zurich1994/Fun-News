package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.toolsBean.Change;
import com.toolsBean.DB;

public class PhotoDao  {

	public int upLoad(Object[] params) throws SQLException{
		String sql="insert into tb_photo values(?,?,?,?)";
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		int i=mydb.getCount();
		return i;
	}
}