package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.toolsBean.Change;
import com.toolsBean.DB;
import com.valueBean.MediaSingle;

public class MediaDao {
	
	/**
	 * @���ܣ��ϴ���Ƶ
	 * @throws SQLException
	 */
	public int upLoad(Object[] params) throws SQLException{
		String sql="insert into tb_media values(?,?,?,?,?,?,?)";
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		int i=mydb.getCount();
		return i;
	}
}
