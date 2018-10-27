package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PraiseDao;
import com.toolsBean.Change;
import com.valueBean.PraiseSingle;

public class PraiseServlet extends HttpServlet {
	
       
    private static final String CONTENT_TYPE = null;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public PraiseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType(CONTENT_TYPE); 
		int Praise_type=1;
		{	int Praise_id=1;									
			int Praise_fun_id=Change.strToInt(request.getParameter("Fun_id"));
			int Praise_user_id=Change.strToInt(request.getParameter("current_userid"));
			//int Praise_type=1;//request.getParameter("commentcontent");
			String Praise_time=Change.dateTimeChange(new Date());
			
			
			PraiseDao praiseDao=new PraiseDao();
			try {
				//PraiseDao.select(Comment_id);
				praiseDao.insert(new Object[]{Praise_id,Praise_time,Praise_user_id,Praise_fun_id,Praise_type});
			} catch (SQLException e) {			
				
				e.printStackTrace();				
			}			
		}
		
	     out.write(Praise_type);
		
		
	}

	
	
}