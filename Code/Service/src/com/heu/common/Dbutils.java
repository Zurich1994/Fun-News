package com.heu.common;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbutils {
	
private static Connection conn;
public static Connection getConnection()
{
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		//2.产生连接对象，连接数据库
		String url="jdbc:mysql://sqld.duapp.com:4050/lSvKBgiabRfWkrjcSUWC";
		String user = "2524f6a8724c4059b08b964f6711a13d";//用户名(api key);
		String password = "c236e684ce3c4068939b210cf163fb29";//密码(secret key)	
	/*String url="jdbc:mysql://localhost:3306/android";
		String user="root";
				String password="sa";*/
		conn=DriverManager.getConnection(url, user, password);
		System.out.println("OK");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
	}

public static void closeConnection(){
	try {
		if(conn!=null)
		{
		conn.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
}
public static void closeResultSet(ResultSet rs)
{
	try {
		if(rs!=null)
		{
		rs.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

public static void closeStatement(Statement stmt)
{
	try {
		if(stmt!=null)
		{
		stmt.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}

	


