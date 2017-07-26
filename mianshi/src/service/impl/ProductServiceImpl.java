package service.impl;

import java.util.List;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import entity.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao productdao=new ProductDaoImpl();
	//查找所有题
	@Override
	public int findAll() {
		
		return productdao.findAll();
	}
	//id查询
	@Override
	public List<Product> findById(int id) {
		
		return productdao.findById(id);
	}
	//保存题
	@Override
	public void save(String total ,String asquestion,int id) {
		productdao.save(total,asquestion ,id);
		
	}
	//查找所有题
	@Override
	public List<Product> find() {
		// TODO Auto-generated method stub
		return productdao.find();
	}
}
