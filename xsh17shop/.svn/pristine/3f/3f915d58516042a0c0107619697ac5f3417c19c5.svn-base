package com.bdqn.service.impl;

import java.util.List;
import java.util.Objects;

import com.bdqn.common.PageBean;
import com.bdqn.dao.ProductDao;
import com.bdqn.entity.Product;
import com.bdqn.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean =  new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		
		int limit = 12 ;
		pageBean.setLimit(limit);
		
		int totalCount = productDao.findCount();
		
		pageBean.setTotalCount(totalCount);
		
		int totalPage =0;
		totalPage = (totalCount+limit-1)/limit;
		pageBean.setTotalPage(totalPage);
		//设置显示到页面数据的集合
		int begin = (page -1) * limit;
		List<Product> list = productDao.findByPage(begin,limit);
		pageBean.setList(list);
		
		return pageBean;
	}
	

	@Override
	public PageBean<Product> findByPage(Integer page ,Integer csid) {
		PageBean<Product> pageBean =  new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		
		int limit = 12 ;
		pageBean.setLimit(limit);
		
		int totalCount;
		
		if(Objects.isNull(csid)){
			totalCount = productDao.findCount();
		}else{
			totalCount = productDao.findByCsid(csid).size();
		}
		pageBean.setTotalCount(totalCount);
		
		int totalPage =0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		//设置显示到页面数据的集合
		int begin = (page -1) * limit;
		List<Product> list = productDao.findByPage(begin,limit,csid);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	
	public PageBean<Product> findByPage(Integer page ,List<Product> list) {
		PageBean<Product> pageBean =  new PageBean<Product>();
		
		if(list.size() <= 0){
					
			return pageBean;
		}
		//设置当前页数
		pageBean.setPage(page);
		
		int limit = 12 ;
		pageBean.setLimit(limit);
		
		int totalCount = list.size();
		
		pageBean.setTotalCount(totalCount);
		
		int totalPage =0;
		totalPage = (totalCount+limit-1)/limit;
		pageBean.setTotalPage(totalPage);
		//设置显示到页面数据的集合
		int begin = (page -1) * limit;
		
		pageBean.setList(list.subList(begin, (begin + limit) < list.size() ? (begin + limit) : list.size() ));
		
		return pageBean;
	}

	@Override
	public void save(Product product) {
		productDao.save(product);
	}

	@Override
	public Product findByPid(int pid) {
		return productDao.finByPid(pid);
	}

	@Override
	public void delete(Product product) {
		productDao.delete(product);
	}

	@Override
	public List<Product> findByCsid(int csid) {
		
		return productDao.findByCsid(csid);
	}
	
	public List<Product> findHot(){
		return productDao.findHot();
		
	}

	@Override
	public List<Product> findNew() {
		return productDao.findNew();
	}

}
