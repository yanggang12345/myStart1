package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;


/**
 * 数据库连接类
 * <p>Title:DBUtils<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author 123456
 * <p>杨刚</p>
 */

public class DBUtils {
	private static String url="jdbc:mysql:///test";
	private static String username="scott";
	private static String password="accp";
	private static Product news=new Product();
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initDBInfo(String url, String username, String password){
		DBUtils.url = url;
		DBUtils.username = username;
		DBUtils.password = password;
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	
	/**
	 * 执行insert update delete语句,并返回受影响的行数
	 */
	public static int executeUpdate(String sql, Object... params){
		if(Utils.isEmpty(sql)) return 0;
		try(Connection conn = getConnection()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				if(params.length > 0){
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
				return ps.executeUpdate();
			}
		}catch(Exception e){
			throw new DataAccessException(e);
		}
	}
	
	/**
	 * 执行sql查询
	 * @param converter 一个行转换器，将ResultSet中的一行数据转换为实体对象
	 * @param sql 要执行的sql语句
	 * @param params 参数
	 * @return 查询的实体对象集合
	 */
	public static <Product> List<Product> executeQuery(String sql, Object... params){
		List<Product> list = new ArrayList<>();
		if(Utils.isEmpty(sql)) return list;
		try(Connection conn = getConnection()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				if(params!=null){
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
				try(ResultSet rs = ps.executeQuery()){
					
					while(rs.next()){
						try{
							news.setId(rs.getInt("id"));
							news.setTitle(rs.getString("title"));
							news.setA(rs.getString("a"));
							news.setB(rs.getString("b"));
							news.setC(rs.getString("c"));
							news.setD(rs.getString("d"));
							news.setAnwer(rs.getString("anwer"));
							news.setAsquestion(rs.getString("asquestion"));
							news.setTotal(rs.getString("total"));
							list.add((Product) news);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
						//从resultset中读取一行数据，并转换为实体对象
					
				}
			}
		}catch(Exception e){
			throw new DataAccessException(e);
		}
		return list;
	}
	
	public List<Product> executeQuery1(String sql, Object... params){
		List<Product> list = new ArrayList<>();
		if(Utils.isEmpty(sql)) return list;
		try(Connection conn = getConnection()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				if(params!=null){
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
				try(ResultSet rs = ps.executeQuery()){
					
					while(rs.next()){
						try{
							Product news=new Product();
							news.setId(rs.getInt("id"));
							news.setTitle(rs.getString("title"));
							news.setA(rs.getString("a"));
							news.setB(rs.getString("b"));
							news.setC(rs.getString("c"));
							news.setD(rs.getString("d"));
							news.setAnwer(rs.getString("anwer"));
							news.setAsquestion(rs.getString("asquestion"));
							news.setTotal(rs.getString("total"));
							list.add((Product) news);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
						//从resultset中读取一行数据，并转换为实体对象
					
				}
			}
		}catch(Exception e){
			throw new DataAccessException(e);
		}
		return list;
	}
	
	public static int executeQueryWithUniqueResult(String sql, Object... params){
		if(Utils.isEmpty(sql)) return 0;
		try(Connection conn = getConnection()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				if(params !=null){
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()){
						return rs.getInt(1);
					}
				}
			}
		}catch(Exception e){
			throw new DataAccessException(e);
		}
		return 0;
	}
}
