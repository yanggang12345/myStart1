package com.itheima.bos.service.impl;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.WorkordermanageDao;
import com.itheima.bos.domain.Workordermanage;
import com.itheima.bos.service.IWorkordermanageService;


@Service
@Transactional
public class WorkordermanageServiceImpl implements IWorkordermanageService{
	@Resource
	private WorkordermanageDao workordermanageDao;

	public void save(Workordermanage model) {
		model.setUpdatetime(new Date());
		try {
			workordermanageDao.save(model);
			ServletActionContext.getResponse().getWriter().print("1");
		} catch (Exception e) {
			try {
				ServletActionContext.getResponse().getWriter().print("0");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}		
	}
}
