package com.springmvc.config;



import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Bootstrap implements WebApplicationInitializer{



	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		servletContext.getServletRegistration("default").addMapping("/css/*","/js/*","/images/*","/fonts/*");
		//注册根容器
		AnnotationConfigWebApplicationContext root=new AnnotationConfigWebApplicationContext();
		root.register(ApplicationConfig.class);
		servletContext.addListener(new ContextLoaderListener(root));
		//注册web容器
		AnnotationConfigWebApplicationContext webContext=new AnnotationConfigWebApplicationContext();
		webContext.register(WebMvcConfig.class);
		webContext.setParent(root);//将根容器设置为web上下文的父容器
		
		DispatcherServlet servlet=new DispatcherServlet(webContext);
		//注册servlet
		ServletRegistration.Dynamic dynamic=servletContext.addServlet("springDispatcher", servlet);
		dynamic.addMapping("/");
		
	}



	
}
