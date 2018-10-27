package com.heu.controllor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.service.UserDaoImpl;

public class Register extends HttpServlet {

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
		boolean a=true;
	    String name=request.getParameter("user_name");
	    String password=request.getParameter("password");
	    int x=(int)(Math.random()*100);
	    int y=(int)(Math.random()*100);
	    String account="00"+Integer.toString(x)+Integer.toString(y);
	    UserDaoImpl udi=new UserDaoImpl();
	    a=udi.register(name, password, account);
	if(a)
	{
		out.write(account);
	}else
	{
		out.write("false");
	}
		out.flush();
		out.close();
	}

}
