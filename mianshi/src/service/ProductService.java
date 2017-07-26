package service;

import java.util.List;

import entity.Product;

public interface ProductService {
	
	int findAll();

	List<Product> findById(int id);

	void save(String total ,String asquestion,int id);
	
	public List<Product> find();
}
