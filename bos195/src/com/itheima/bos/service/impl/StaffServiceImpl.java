package com.itheima.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IStaffDao;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	//注入dao
	@Autowired
	private IStaffDao staffDao;

	public void save(Staff model) {
		
		staffDao.save(model);
	}

	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
		
	}

	public void deleteBatch(String ids) {
		String[] staffDeleteIds = ids.split(",");
		for (String id : staffDeleteIds) {
			staffDao.executeUpdate("staff.delete", id);
		}
		
	}

	public Staff findById(String id) {
		return staffDao.findById(id);
	}

	public void update(Staff staff) {
		staffDao.update(staff);
		
	}

	public List<Staff> findListNotDelete() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		detachedCriteria.add(Restrictions.ne("deltag", "1"));//ne 不等于
	
		return staffDao.findByCriteria(detachedCriteria);
	}
}
