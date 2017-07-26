package com.bdqn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 继承response，request，以获取session中的值
 * <p>Title:BaseAction<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @date 2017年7月26日 下午4:01:10
 * @author 123456
 * <p>杨刚</p>
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{  
	  
	  
    protected HttpServletRequest request;  
    protected HttpServletResponse response;  
      
    @Override  
    public void setServletResponse(HttpServletResponse arg0) {  
        this.response= arg0;  
    }  
  
    @Override  
    public void setServletRequest(HttpServletRequest arg0) {  
        this.request = arg0;  
    }  
  
      
      
}  
