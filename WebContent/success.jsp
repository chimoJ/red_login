<%@page import="com.imooc.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
   <% //判断session中是否有用户的信息
     if (session.getAttribute("user")!=null){
    	    User user = (User)session.getAttribute("user");
    	    //获得绝对路径最后一个/的位置
    	    int lastindex=user.getPath().lastIndexOf("/");
    	    //获得文件上传时的唯一文件名
    	    String fileName=user.getPath().substring(lastindex+1);
    	    
    	    
   %>
      <div class="login">
		<div class="header">
			<h1>登录成功</h1>
		</div>
		<div class="content">
			<table align="center">
				<tr>
					<td align="center"><img src="/reg_login1/upload/<%=fileName %>" /></td>
				</tr>
				<tr>
					<td align="center">欢迎<%=user.getNickname() %>,登录成功！</td>
				</tr>
			</table>

		</div>
	</div>	
   <%
     }else {
   %>
   <div class="login">
      <div class="header">
			<h1>请先<a href="/reg_login1/login.jsp">登录!</a></h1>
		</div>
   </div>
   <% 
     }
   %>
	
</body>
</html>
