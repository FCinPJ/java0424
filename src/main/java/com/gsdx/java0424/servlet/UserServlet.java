package com.gsdx.java0424.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gsdx.java0424.entity.Userinfo;
import com.gsdx.java0424.service.UserinfoService;

public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("op");
		if("reg".equals(action)){
			doReg(request, response);
		}
		if("login".equals(action)){
			doLogin(request, response);
		}
	}
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String username=request.getParameter("username");
		  String password=request.getParameter("password");
		  String realname=request.getParameter("realname");
		  Userinfo user=new Userinfo();
		  user.setPassword(password);
		  user.setRealname(realname);
		  user.setUsername(username);
		  UserinfoService service=new UserinfoService();
		  boolean result= service.login(user);
		  PrintWriter out= response.getWriter();
		  if (result) {
			out.print("登录成功");
		  }
		  else {
			  out.print("登录失败");
		  }
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String username=request.getParameter("username");
		  String password=request.getParameter("password");
		  String realname=request.getParameter("realname");
		  Userinfo user=new Userinfo();
		  user.setPassword(password);
		  user.setRealname(realname);
		  user.setUsername(username);
		  UserinfoService service=new UserinfoService();
		  int result= service.registerUser(user);
		  PrintWriter out= response.getWriter();
		  if(result>0){
			 response.sendRedirect("login.jsp");
		  }else if(result==0){
			  out.println("<script>alert('注册失败');history.go(-1);<script/>");
		  }else{
			  out.println("<script>alert('注册失败,用户名已经存在');history.go(-1);<script/>");
		  }
				  
	}

}
