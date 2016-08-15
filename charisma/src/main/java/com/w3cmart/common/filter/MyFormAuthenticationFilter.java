package com.w3cmart.common.filter;

import java.io.PrintWriter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {

		 if (isLoginRequest(request, response)) {  
	        	//login目前都不是ajax的
	        	HttpServletRequest request2 = (HttpServletRequest)request;
	        	if("GET".equalsIgnoreCase(request2.getMethod())){
	        		//get代表要跳转到登录页
	        		return true;
	        	}
	        	if(request.getAttribute(getFailureKeyAttribute()) != null) {
	                return true;
	            }
	        	//登录
	            return executeLogin(request, response);
	        } else {  
	        	HttpServletResponse response2 = (HttpServletResponse)response;
	        	HttpServletRequest req = (HttpServletRequest)request;
	        	if(SecurityUtils.getSubject().isRemembered()){
	        		return true;
	        	}
	        	 StringBuffer url = req.getRequestURL();
	        	 if (req.getQueryString() != null) {
	        	  url.append('?');
	        	  url.append(req.getQueryString());
	        	 }
	        	 String ur = url.toString();
	        	response2.setCharacterEncoding("UTF-8");  
	            if (!"XMLHttpRequest"  
	                    .equalsIgnoreCase(((HttpServletRequest) request)  
	                            .getHeader("X-Requested-With"))) {
	            	// 不是ajax请求  
//	            	redirectToLogin(request, response);
	                PrintWriter out = response2.getWriter(); 
	                String loginUrl = getLoginUrl();
	                WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();  
	                ServletContext servletContext = webApplicationContext.getServletContext(); 
	                String contextPath = servletContext.getContextPath();
	                out.println("<script>window.top.location.href='"+contextPath+"/pages/jsp/login.jsp"+"'</script>");   
	                out.flush();  
	                out.close();  
	            } else {  
//	            	redirectToLogin(request, response);
	            	response2.setCharacterEncoding("UTF-8");  
	                PrintWriter out = response2.getWriter(); 
	                response2.setStatus(999);
	                out.println(getLoginUrl());  
	                out.flush();  
	                out.close();  
	            }  
	            return false;  
	        }  
	}
}
