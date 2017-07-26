package com.itheima.bos.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.domain.Function;
import com.itheima.bos.domain.User;
import com.itheima.bos.service.IFunctionService;
import com.itheima.bos.utils.BOSContext;
import com.itheima.bos.utils.PageBean;

@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService{
	@Resource
	private IFunctionDao functionDao;

	public void pageQuery(PageBean pageBean) {
		functionDao.pageQuery(pageBean);
		
	}

	public List<Function> findAll() {
		return functionDao.findAll();
		
	}

	public void save(Function model) {
		Function function = model.getFunction();
		if(function!=null&&function.getId().equals("")){
			model.setFunction(null);
		}
		functionDao.save(model);
		
	}
	/**
	 * 查询菜单
	 */
	public List<Function> findMenu() {
		User user =BOSContext.getLoginUser();
		List<Function> list=null;
		if(user.getUsername().equals("admin")){
			//查询所有菜单
			list=functionDao.findAllMenu();
		}else{
			//普通用户，查询对应的菜单
			list=functionDao.findMenuByUserid(user.getId());
		}
		
		return list;
	}
}
