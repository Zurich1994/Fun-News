package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.toolsBean.Change;
import com.toolsBean.DB;
import com.valueBean.ArtReviewSingle;
public class ArtReviewDao{	

	private List getList(String sql,Object[] params) throws SQLException{
		List list=null;
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			list=new ArrayList();
			while(rs.next()){
				ArtReviewSingle single=new ArtReviewSingle();
				single.setId(rs.getInt(1));
				single.setArtRootId(rs.getInt(2));
				single.setArtAuthor(rs.getString(3));
				single.setArtContent(rs.getString(4));
				single.setArtTime(Change.dateTimeChange(rs.getTimestamp(5)));
				list.add(single);
			}
		}
		return list;
	}
	public void insert(Object[] params) throws SQLException{
		String sql="insert into tb_articleR values(?,?,?,?)";
		DB mydb=new DB();
		mydb.doPstm(sql, params);
	}
	public int delete(int id) throws SQLException{
		String sql="delete from tb_articleR where id=?";
		DB mydb=new DB();
		mydb.doPstm(sql, new Object[]{id});
		int i=mydb.getCount();
		return i;		
	}
}
