package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ArtReviewDao;
import com.toolsBean.Change;
import com.valueBean.UserSingle;

public class ArtReviewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String commentcontent=request.getParameter("commentcontent");
		String action=request.getParameter("action");
		 if("review".equals(action))
			doReview(request,response);
		 
		
		else if("delete".equals(action))
			doDelete(request,response);
		else
			doOther(request,response);
	}

	
	protected void doReview(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		int message=validateInsert(request);		
		{											
			String rootId=request.getParameter("artrootId");
			String content=request.getParameter("artContent");
			String time=Change.dateTimeChange(new Date());
			String author="";
			String noname=request.getParameter("noname");
			{										
				HttpSession session=request.getSession();
				author=((UserSingle)session.getAttribute("logoner")).getUserName();
			}
			
			ArtReviewDao artReviewDao=new ArtReviewDao();
			try {
				artReviewDao.insert(new Object[]{rootId,author,content,time});
			} catch (SQLException e) {			
				message=1;//"∑¢±Ì∆¿¬€ ß∞‹£°" =1
				e.printStackTrace();				
			}			
		}
	     out.write(message);
		
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int message=0;
		PrintWriter out=response.getWriter();
		int rootId=Change.strToInt(request.getParameter("artrootId"));
		int id=Change.strToInt(request.getParameter("id"));
		
		int i=0;
		try {
			ArtReviewDao artReviewDao=new ArtReviewDao();
			i=artReviewDao.delete(id);
		} catch (SQLException e) {
			i=-1;
			e.printStackTrace();
		}
		if(i<=0){
			message=3;//…æ≥˝∆¿¬€ ß∞‹£°=3
			
		}
		else{
			message=4;//…æ≥˝∆¿≥…π¶£°=4
			
		}
		
		out.write(message);		
		
	}
	protected void doOther(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
	}
	private int validateInsert(HttpServletRequest request) throws ServletException, IOException{
		int message = 0;
		String content=request.getParameter("artContent");
		if(content==null||content.equals(""))
			message=2;//«Î ‰»Î∆¿¬€=2
		return message; 
	}
}