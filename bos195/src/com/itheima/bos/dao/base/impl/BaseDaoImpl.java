package com.itheima.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itheima.bos.dao.base.IBaseDao;
import com.itheima.bos.domain.Region;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.utils.PageBean;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	//实体类
	private Class<T> entityClass;
	
	//使用注解方式进行依赖注入
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);

	}
	/*
	 * 在构造方法中操作的实体类型
	 */
	public BaseDaoImpl() {
		//获得父类（BaseDaoImpl<T>）类型
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得父类上的泛型数组
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}
	
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);

	}

	
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);

	}

	
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);

	}

	
	public T findById(Serializable id) {
		
		return this.getHibernateTemplate().get(entityClass, id);
	}

	
	public List<T> findAll() {//from user
		/*User.class.getSimpleName();*/
		String hql="FROM "+entityClass.getSimpleName();
		return this.getHibernateTemplate().find(hql);
	}
	
	/*
	 * 通用更新方法
	 */
	public void executeUpdate(String queryName,Object...objects){
		Session session = this.getSession();//本地线程中获得session对象
		//使用命名查询语句获得查询对象
		Query query = session.getNamedQuery(queryName);
		//位HQL语句中的？赋值
		int i=0;
		int b=0;
		for(Object arg:objects){
			query.setParameter(i++, arg);
			System.out.println(b++);
		}
		query.executeUpdate();//执行更新
	}
	public void pageQuery(PageBean pageBean) {
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		//总数量----select count(*) from bc_staff
		//改变Hiibernate 框架发出的sql形式
		detachedCriteria.setProjection(Projections.rowCount());//select count(*) from bc_staff
		List<Long> list=this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long total=list.get(0);
		pageBean.setTotal(total.intValue());//设置总数据量
		detachedCriteria.setProjection(null);//修改sql的形式 select * from bc_staff
		//重置表和类的映射关系
		detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
		//当前页展示的数据集合
		 int firstResult=(currentPage-1)*pageSize;
		 int maxResults=pageSize;
		 List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		 pageBean.setRows(rows);
		 
	}
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		
		return this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}
	
}
