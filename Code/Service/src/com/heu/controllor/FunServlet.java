package com.heu.controllor;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.dao.Tools;

public class FunServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	    //String operate=request.getParameter("operate");
	    //System.out.println("数值为:"+operate);
		String time=request.getParameter("time");
		Tools tool=new Tools();
		if(time==null||time.length()<=0)
		{
			Calendar c = Calendar.getInstance();
			 c.setTimeInMillis(new Date().getTime());
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 String time2=dateFormat.format(c.getTime());
		     
		     out.write(tool.showfun(0,2,time2));
		}else
		{
	     out.write(tool.showfun(0,2,time));}
        	
        	
       // }
       /* if(operate.equals("2"))//显示收藏的段子
        {   int user_id=Integer.parseInt(request.getParameter("id"));
        	out.write(tool.showfun(user_id, 2));
        }*/
	    
	
		out.flush();
		out.close();
	}

}
