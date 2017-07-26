package com.bdqn.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBUtils {
	private static final String CONNECTION_STR = "jdbc:mysql://localhost:3306/test0423";
	private static final String USERNAME = "shan";
	private static final String PASSWORD = "123123";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(CONNECTION_STR, USERNAME, PASSWORD);
	}
	
	public static int executeUpdate(String sql, Object...values){
		try(Connection conn=DBUtils.getConnection()){
			try(PreparedStatement ps=conn.prepareStatement(sql)){
				if(values.length>0){
					for(int i=0;i<values.length;i++){
						ps.setObject(i+1, values[i]);
					}
				}
				return ps.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public static <T> List<T> executeQuery(RowConverter<T> converter,String sql,Object ...values){
		List<T> list=new ArrayList<>();
		try(Connection conn=DBUtils.getConnection()){
			try(PreparedStatement ps=conn.prepareStatement(sql)){
				if(values.length>0){
					for(int i=0;i<values.length;i++){
						ps.setObject(i+1, values[i]);
					}
				}
				//从resultset中读取一行数据，并转换为实体对象
				try(ResultSet rs=ps.executeQuery()){
					while(rs.next()){
						//从resultset中读取一行数据，并转换为实体对象
						T entity = converter.convert(rs);
						list.add(entity);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public static int executeQueryWithUniqueResult(String sql, Object... params){
		try(Connection conn = getConnection()){
			try(PreparedStatement ps = conn.prepareStatement(sql)){
				if(params.length > 0){
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
			e.printStackTrace();
		}
		return 0;
	}
}
