package com.wwb.filter;

import java.io.IOException; 
import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
public class LoginActionFilter implements Filter { 

    
    public void destroy() { 
     } 
    public void doFilter(ServletRequest arg0, ServletResponse arg1, 
             FilterChain filterChain) throws IOException, ServletException { 
         HttpServletRequest request = (HttpServletRequest)arg0; 
         HttpServletResponse response = (HttpServletResponse)arg1; 
         HttpSession session = request.getSession(); 
         System.out.println("进入过滤器");
//         System.out.println("url=="+request.getRequestURI());
//         System.out.println("url=="+request.getRequestURI().indexOf("login.jsp"));
        if(session.getAttribute("user")== null && request.getRequestURI().indexOf("login.jsp")==-1 ){ 
        	if(request.getRequestURI().indexOf("loginPro.action")==-1){
        	System.out.println("进入过滤器+Login.jsp"); 
        	response.sendRedirect("login.jsp"); 
            return ; 
        	}
         } 
         filterChain.doFilter(arg0, arg1); 
     } 
    public void init(FilterConfig arg0) throws ServletException { 
     } 
}	
