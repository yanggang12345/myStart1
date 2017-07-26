package com.bdqn.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.common.PageHibernateCallback;
import com.bdqn.dao.CategorySecondDao;
import com.bdqn.entity.CategorySecond;

public class CategorySecondDaoImpl  extends HibernateDaoSupport implements CategorySecondDao{

	@Override
	public List<CategorySecond> findAll() {
		String hql ="from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().saveOrUpdate(categorySecond);
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//分页二级分类的方法
	public List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<>(hql, null, begin, limit));
		if(list !=null && list.size() >0){
			return list;
		}
		return null;
	}

	@Override
	public CategorySecond findByCsid(int csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	//删除二级分类
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
	}

	@Override
	public List<CategorySecond> findByCid(int cid) {
		String hql ="from CategorySecond where cid= " + cid;
		return this.getHibernateTemplate().find(hql);
	}

}
