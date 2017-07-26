package dao;

import java.sql.ResultSet;
import java.util.List;

import entity.Product;


/**
 * 产品dao层
 * <p>Title:ProductDao<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author 123456
 * <p>杨刚</p>
 */
public interface ProductDao{
	/**
	 * 查找题的数量
	 * @return
	 */
	public int findAll();
	/**
	 * 按题的id查询
	 * @param id
	 * @return
	 */
	public List<Product> findById(int id);
	/**
	 * 同步成绩和回答的答案
	 * @param total
	 * @param asquestion
	 * @param id
	 */
	void save(String total ,String asquestion,int id);
	/**
	 * 查找所有题
	 * @return
	 */
	public List<Product> find();
}
