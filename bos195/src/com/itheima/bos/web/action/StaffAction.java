package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	
	/*
	 * 添加取派员
	 */
	public String add(){
		staffService.save(model);
		return "list";
	}
	/*
	 * 分页查询方法
	 */
	public String pageQuery() throws IOException{
		
		staffService.pageQuery(pageBean);
		//将PageBean对象转为json返回
		this.writePageBean2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","decidedzones"});
		return NONE;
	}
	/*
	 * 接受IDS数据
	 */
	public void setIds(String ids) {
		this.ids = ids;
	}

	private String ids;
	/*
	 * 批量删除
	 */
	@RequiresPermissions(value="staff")//执行当前方法需要具有staff权限
	//@RequiresRoles(value="abc")
	public String delete(){
		staffService.deleteBatch(ids);
		return "list";
	}
	public String edit(){
		//先查询数据库中的原始数据
		Staff staff=staffService.findById(model.getId());
		//再按照页面提交的参数进行覆盖
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setStation(model.getStation());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staffService.update(staff);
		return "list";
	}
	//查询在职的取派员
	public String listajax() throws IOException{
		List<Staff> list = staffService.findListNotDelete();
		String[] excludes=new String[]{"decidedzones"};
		this.writeList2Json(list, excludes);
		return NONE;
		
	}
}
