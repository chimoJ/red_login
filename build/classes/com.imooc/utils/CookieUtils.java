package com.imooc.utils;
import javax.servlet.http.Cookie;
//cookie查找工具类
public class CookieUtils {
    public static Cookie findcookie(Cookie[] cookies,String name) {
    	   if(cookies==null) return null;
    	   else {
    		   for(Cookie cookie:cookies) {
    			   name.equals(cookie.getName());
    			   return cookie;
    		   }
    		   return null;
    	   }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
