package com.heu.controllor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DownLoadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

	
	File f= new File("C:/apache-tomcat-7.0.56-windows-x86/apache-tomcat-7.0.56/webapps/Service/Image/0.jpg");
	boolean a=f.exists();
	System.out.println(a);
	if(f.exists())
	{
		
		FileInputStream fis= new FileInputStream(f);
		String filename=URLEncoder.encode(f.getName(),"utf-8");
		byte[] b= new byte[fis.available()];
		fis.read(b);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="+filename+"");
		ServletOutputStream out2=response.getOutputStream();
	
		out2.write(b);

		
		out2.flush();
		out2.close();
	}
	
		
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
