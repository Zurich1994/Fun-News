package com.heu.controllor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.dao.Tools;

public class CheckLoginServlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	
		String account=request.getParameter("user_id");
		String password=request.getParameter("user_password");
		Tools tool= new Tools();
		boolean a=tool.isTure(account, password);
		if(a)
		{
			out.write("true");
		}
		else
		{
			out.write("false");
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
