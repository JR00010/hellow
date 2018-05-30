package com.frame.mcv.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.ir.debug.JSONWriter;

import com.frame.mcv.service.SummerContext;

public class DispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private SummerContext summerContext;

	/**
	 * Constructor of the object.
	 */
	public DispatcherServlet() {
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
		System.err.println("--------------------------------------------");
//		System.err.println("+++"+request.getQueryString());
//		Enumeration<String> e = request.getParameterNames();
		Map<String, String[]> sssss = request.getParameterMap();
//		System.err.println("1111111111"+sssss);
//		while (e.hasMoreElements()) {
//		    Object o= e.nextElement();
//		    System.out.println(o);
//		}
		
		request.getRemoteAddr();
		request.getContentType();
		request.isRequestedSessionIdFromURL();
		Map<String, String[]> map = new HashMap<String, String[]>(sssss);
//		System.err.println("+++"+request.getRequestURI());
//		System.err.println("---0000------"+request.getContextPath());
//		
//		System.err.println("---------"+request.getRequestURL());
//		System.err.println("----request.getServletPath()----"+request.getServletPath());
		try {
			summerContext.getHandlerMapping().excut(request.getServletPath(),map);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println(new book());
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the GET method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
		
		
        
      HttpServletResponse httpResponse = (HttpServletResponse) response;  
      httpResponse.setHeader("Access-Control-Allow-Origin", "*");  
      httpResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");  
      httpResponse.setHeader("Access-Control-Allow-Credentials", "true");  
//      chain.doFilter(request, httpResponse);  
      httpResponse.sendRedirect("http://localhost:8016/boot/hello");
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
		doGet(  request,  response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.err.println("..............");
		this.summerContext = new SummerContext();
	}
	
	
	private  void dispatchRequest(String request) throws Exception{
//		Map<String, Object>	requstInfo =  summerContext.getHandlerMapping();
//		handlerAdapterImpl.invoke(requstInfo);
		//	      //记录每一个请求
		//	      trackRequest(request);
		//	      //对用户进行身份验证
		//	      if(isAuthenticUser()){
		//	         dispatcher.dispatch(request);
		//	      }	
	}
	
	
	private String getRequestPath (HttpServletRequest request) {
		String contextName = request.getContextPath();
		
		return null;
		
	}

}
