package com.itheima.bos.web.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.itheima.bos.crm.CustomerService;
import com.itheima.bos.service.IDecidedzoneService;
import com.itheima.bos.service.IFunctionService;
import com.itheima.bos.service.INoticebillService;
import com.itheima.bos.service.IRegionService;
import com.itheima.bos.service.IRoleService;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.service.ISubareaService;
import com.itheima.bos.service.IUserService;
import com.itheima.bos.service.IWorkordermanageService;
import com.itheima.bos.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/*
 * 通用action
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	//注入Service
	@Resource
	protected IUserService userService;
	@Resource
	protected CustomerService customService;//远程代理接口
	@Autowired
	protected IRegionService regionService;
	@Autowired
	protected IStaffService staffService;
	@Autowired
	protected ISubareaService subareaService;
	@Autowired
	protected IDecidedzoneService decidedzoneService;
	@Autowired
	protected INoticebillService noticebillService;
	@Autowired
	protected IWorkordermanageService workordermanageService;
	@Autowired
	protected IFunctionService functionService;
	@Autowired
	protected IRoleService roleService;
	
	protected PageBean pageBean=new PageBean();
	DetachedCriteria detachedCriteria =null;
	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}
	public void setPage(int page) {
		pageBean.setCurrentPage(page);
	}
	//模型对象
	protected T model;
	public T getModel() {
		return model;
	}
	
	public void writePageBean2Json(PageBean pageBean,String[] excludes) throws IOException{
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(excludes);
		JSONObject jsonObject=JSONObject.fromObject(pageBean,jsonConfig);
		String json=jsonObject.toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(json);
	}
	/*
	 * 
	 * 在构造方法中动态获得实例额类型，通过反射创建模型对象
	 */
	public BaseAction(){
		ParameterizedType genericSuperclass = null;
		if(this.getClass().getGenericSuperclass() instanceof ParameterizedType){
			genericSuperclass=(ParameterizedType) this.getClass().getGenericSuperclass();
		}else{//为当前Action创建了代理
			genericSuperclass=(ParameterizedType) this.getClass().getSuperclass().getGenericSuperclass();
		}
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		detachedCriteria = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
		try {
			model=entityClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeList2Json(List list, String[] excludes) throws IOException {
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(excludes);
		JSONArray jsonArray=JSONArray.fromObject(list,jsonConfig);
		String json=jsonArray.toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(json);
	}
	
	public void writeObject2Json(Object object,String[] excludes) throws IOException{
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(excludes);
		JSONObject jsonObject=JSONObject.fromObject(object,jsonConfig);
		String json=jsonObject.toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(json);
	}
	
}
