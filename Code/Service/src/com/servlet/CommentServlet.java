package com.servlet;
import java.io.DataOutputStream;  
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CommentDao;
import com.toolsBean.Change;
import com.valueBean.UserSingle;

public class CommentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response, String CONTENT_TYPE)throws ServletException, IOException {
		String praise=request.getParameter("Praise");
		
		 if("Praise".equals(praise))
			doPraise(request,response);
		 response.setContentType(CONTENT_TYPE);
		
		
	}

	
	protected void doPraise(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		PrintWriter out=response.getWriter();
				
		{	//int comme_id=1;									
			int Fun_id=Change.strToInt(request.getParameter("Fun_id"));
			int current_user_id=Change.strToInt(request.getParameter("current_userid"));
			String Comment_content=request.getParameter("commentcontent");
			String Comment_time=Change.dateTimeChange(new Date());
			
			
			CommentDao commentDao=new CommentDao();
			try {
				commentDao.insert(new Object[]{Comment_content,Comment_time,Fun_id,current_user_id});
				//Praise_id++;
			} catch (SQLException e) {			
				
				e.printStackTrace();				
			}			
		}
		
	     out.write("Failed!");
		
		
	}

	
	
}