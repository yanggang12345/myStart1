package util;

/**
 * 异常处理类
 * <p>Title:DataAccessException<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author 123456
 * <p>杨刚</p>
 */

public class DataAccessException extends RuntimeException{
	public DataAccessException(){}
	public DataAccessException(String msg){
		super(msg);
	}
	public DataAccessException(String msg, Throwable e){
		super(msg, e);
	}
	public DataAccessException(Throwable e){
		super(e);
	}
}
