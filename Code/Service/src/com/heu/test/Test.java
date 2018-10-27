package com.heu.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.heu.dao.Tools;
import com.heu.service.UserDaoImpl;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//com.heu.dao.Tools tool =new com.heu.dao.Tools();
		//System.out.println(tool.showVideo(1, 1));*/
	/*Calendar c = Calendar.getInstance();
		 c.setTimeInMillis(new Date().getTime());
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time=dateFormat.format(c.getTime());
		 System.out.println(time);
		
			tool.showAll(time);*/
		/*if(tool.isTure("12345678", "12"))
		{
			System.out.println("true");
			}
		else{
			System.out.println("false");
		}*/
		UserDaoImpl udi=new UserDaoImpl();
		boolean a=udi.register("1","1","1");
		System.out.print(a);
		
	}

}
