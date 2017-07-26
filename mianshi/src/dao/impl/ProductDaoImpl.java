package dao.impl;

import java.sql.ResultSet;
import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DBUtils;

public class ProductDaoImpl implements ProductDao{

	@Override
	public int findAll() {
		String sql="select count(title)as num from test";
		
		return DBUtils.executeQueryWithUniqueResult(sql, null);
	}

	@Override
	public List<Product> findById(int id) {
		String sql="select * from test where id=?";
		return DBUtils.executeQuery( sql, id);
	}

	public List<Product> find(){
		String sql="select * from test";
		DBUtils dbUtils=new DBUtils();
		return dbUtils.executeQuery1(sql, null);
	}
	@Override
	public void save(String total ,String asquestion,int id) {
		String sql="update test set asquestion=? ,total=? where id=?";
		DBUtils.executeUpdate(sql, asquestion,total,id);
	}

	
}
