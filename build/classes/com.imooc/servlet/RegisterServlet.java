package com.imooc.servlet;
import com.imooc.domain.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//从servlet context 中接受list，遍历找到相对应的username
		List<User> list=(List<User>) this.getServletContext().getAttribute("list");
		//取出list之后对集合进行遍历 找到对应的用户信息
		for(User u:list) {
			//判断用户名和密码是否正确
			if(username.equals(u.getUsername())) {
				if(password.equals(u.getPassword())) {
					//用户名以及密码都正确
					//登录成功
					//判断记住用户名的复选框是否勾选
					String checkbox=request.getParameter("remember");
					if(checkbox.equals("true")) {
						//记住用户名
						Cookie cookie= new Cookie("username",u.getUsername());
						//将cookie会写到浏览器
						response.addCookie(cookie);
						//设置cookie的有效路径和时长
						cookie.setPath("/reg_login1");
						cookie.setMaxAge(60*30);//时间单位是秒 30min
					}
					//将用户信息保存入session
					request.getSession().setAttribute("user", u);
					response.sendRedirect("/reg_login1/success.jsp");return;
				}
			}
		}
		//登录失败
		request.setAttribute("msg", "登录名或者密码错误！");
		request.getRequestDispatcher("/login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
