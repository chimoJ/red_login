package com.imooc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.imooc.domain.User;
import java.util.*;
/**
 * 用户注册初始化servlet
 */
public class InitServlet extends HttpServlet {
  public void init() throws ServletException{
	  //创建一个list用于保存用户的注册信息
	  List<User> list=new ArrayList<>();//将该list保存到ServletContext的作用域中
	  this.getServletContext().setAttribute("list", list);
  }
}
