package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Function;
import com.itheima.bos.domain.Role;
import com.itheima.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	private String ids;//接收权限id
	/*
	 * 添加角色
	 */
	public String add(){
		roleService.save(model,ids);
		return "list";
	}
	
	/**
	 * 分页查询方法
	 * @return
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException{
		roleService.pageQuery(pageBean);
		String[] excludes=new String[]{"functions","users","currentPage","detachedCriteria","pageSize"};
		//将PageBean对象转化为json返回
		this.writePageBean2Json(pageBean, excludes);
		return NONE;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	/**
	 * 查询所有的角色
	 * @return
	 * @throws IOException
	 */
	public String listajax() throws IOException{
		List<Role> list = roleService.findAll();
		String[] excludes =new String []{"functions","users"};
		this.writeList2Json(list, excludes );
		return NONE;
		
	}
}
