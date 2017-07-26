package entity;

/**
 * 题的属性类
 * <p>Title:Product<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author 123456
 * <p>杨刚</p>
 */

public class Product {
	private int id; //题编号
	private String title;//题标题
	private String a;//题的选项
	private String b;//题的选项
	private String c;//题的选项
	private String d;//题的选项
	private String anwer;//所选中的答案
	private String total; //总分记录
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getAnwer() {
		return anwer;
	}
	public void setAnwer(String anwer) {
		this.anwer = anwer;
	}
	private String asquestion;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public String getAsquestion() {
		return asquestion;
	}
	public void setAsquestion(String asquestion) {
		this.asquestion = asquestion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	
}
