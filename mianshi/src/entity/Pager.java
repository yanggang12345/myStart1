package entity;

/**
 * 分页类
 * <p>Title:Pager<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author 123456
 * <p>杨刚</p>
 */

public class Pager {
	private int page = 1;//当前页
	private int pageSize = 1;//页数
	private int total = 0;//总题数
	
	public Pager(){}
	
	public Pager(int page){
		this.page = page;
	}
	
	public Pager(int page, int pageSize){
		this(page);//调用构造函数  super();
		this.pageSize = pageSize;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage(){
		return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
	}
	
	/**
	 * 是否是第一页
	 * @return
	 */
	public boolean isFirst(){
		return page == 1;
	}
	
	/**
	 * 是否是最后一页
	 * @return
	 */
	public boolean isLast(){
		return page == getTotalPage();
	}
	
	public int getBegin(){
		return (page - 1) * pageSize;
	}
	
	public int getEnd(){
		return page * pageSize;
	}
}
